package com.collectorWeb.service;

import com.collectorWeb.model.dto.DebtDto;
import com.collectorWeb.common.exceptions.DebtNotExistException;
import com.collectorWeb.common.exceptions.DebtorNotExistException;
import com.collectorWeb.model.dto.DebtorDto;
import com.collectorWeb.model.entity.Debt;
import com.collectorWeb.model.entity.Debtor;
import com.collectorWeb.repository.DebtRepository;
import com.collectorWeb.repository.DebtorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DebtService {
    private static DebtRepository debtRepository;
    private static DebtorRepository debtorRepository;

    @Transactional
    public DebtDto add(DebtDto debtDTO) {
        Debtor debtorOfDebt = debtorRepository.getDebtorByUsername(debtDTO.getDebtorUsername());

        if (debtorOfDebt == null) {
            throw new DebtorNotExistException("Debtor with username: "
                    + debtDTO.getDebtorUsername() + " does not exist");
        }

        Debt debt = Debt.builder()
                .title(debtDTO.getTitle())
                .sum(debtDTO.getSum())
                .currency(debtDTO.getCurrency())
                .createdAt(LocalDateTime.now())
                .debtor(debtorOfDebt)
                .description(debtDTO.getDescription())
                .notify(debtDTO.isNotify())
                .build();

        debtRepository.save(debt);
        return debtDTO;
    }

    @Transactional
    public DebtDto delete(int debtId) {
        Debt debt = debtRepository.deleteDebtById(debtId);
        if (debt == null) {
            throw new DebtNotExistException("Debt with id: " + debtId + " does not exist");
        } else {
            return fromEntityToDto(debt);
        }

    }

    @Transactional
    public Debt update(DebtDto debtDTO) {
        Debt debt = debtRepository.getDebtById(debtDTO.getId());
        if(debt == null){
            throw new DebtNotExistException("Debt does not exist");
        }

        if(debtDTO.getTitle() != null){
            debt.setTitle(debtDTO.getTitle());
        }

        if(debtDTO.getDebtorUsername() != null){
            debt.setDebtor(debtorRepository.getDebtorByUsername(debtDTO.getDebtorUsername()));
        }

        if (debtDTO.getSum() != debt.getSum()){
            debt.setSum(debtDTO.getSum());
        }

        if(debtDTO.getCurrency() != null){
            debt.setCurrency(debtDTO.getCurrency());
        }

        if (debtDTO.getDescription() != null){
            debt.setDescription(debtDTO.getDescription());
        }

        if (debtDTO.isNotify() != debt.isNotify()){
            debt.setNotify(debtDTO.isNotify());
        }

        debtRepository.save(debt);
        return debt;
    }

    @Transactional
    public List<Debt> getAllDebts() {
        return debtRepository.findAll();
    }

    public DebtDto fromEntityToDto(Debt debt) {
        return DebtDto.builder()
                .id(debt.getId())
                .debtorUsername(debt.getDebtor().getUsername())
                .title(debt.getTitle())
                .sum(debt.getSum())
                .currency(debt.getCurrency())
                .description(debt.getDescription())
                .notify(debt.isNotify())
                .build();
    }

}

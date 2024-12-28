package com.collectorWeb.service;

import com.collectorWeb.common.dto.DebtDTO;
import com.collectorWeb.common.exceptions.DebtNotExistException;
import com.collectorWeb.common.exceptions.DebtorNotExistException;
import com.collectorWeb.model.entity.Debt;
import com.collectorWeb.model.entity.Debtor;
import com.collectorWeb.repository.DebtRepository;
import com.collectorWeb.repository.DebtorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DebtService {
    private DebtRepository debtRepository;
    private static DebtorRepository debtorRepository;

    public DebtDTO add(DebtDTO debtDTO) {
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

    public DebtDTO delete(int debtId) {
        Debt debt = debtRepository.deleteDebtById(debtId);
        if (debt == null) {
            throw new DebtNotExistException("Debt with id: " + debtId + " does not exist");
        } else {
            return new DebtDTO(debt);
        }

    }

    public DebtDTO update(DebtDTO debtDTO) {
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
        return new DebtDTO(debt);
    }



}

package com.collectorWeb.service;

import com.collectorWeb.model.dto.DebtorDto;
import com.collectorWeb.common.exceptions.DataDuplicationException;
import com.collectorWeb.common.exceptions.DebtorNotExistException;
import com.collectorWeb.model.entity.Debt;
import com.collectorWeb.model.entity.Debtor;
import com.collectorWeb.repository.DebtorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DebtorService {
    private static DebtorRepository debtorRepository;

    @Transactional
    public DebtorDto addDebtor(DebtorDto debtorDTO) {
        try {
            Debtor debtorToAdd = Debtor.builder()
                    .username(debtorDTO.getUsername())
                    .email(debtorDTO.getEmail())
                    .build();

            debtorRepository.save(debtorToAdd);
            return debtorDTO;
        } catch (DataIntegrityViolationException e) {
            throw new DataDuplicationException("Debtor already exists");
        }
    }

    @Transactional
    public List<DebtorDto> getDebtsByAppUserId(int appUserId) {
        List<DebtorDto> debtors = debtorRepository.getDebtorsByAppUserId(appUserId);

        if(debtors.isEmpty()) {
            throw new DebtorNotExistException("Debtor by app user id " + appUserId + " not exist");
        }
        return debtors;
    }

    @Transactional
    public List<DebtorDto> getAllDebtors() {
        List<Debtor> debtors = debtorRepository.findAll();

        if(debtors.isEmpty()) {
            throw new DebtorNotExistException("Debtors don't exist ");
        }

        return debtors.stream()
                .map(this::fromEntityToDto)
                .toList();
    }

    @Transactional
    public Debtor getDebtorByDebt(Debt debt) {
        return debtorRepository.getDebtorByDebtsContaining(debt);
    }

    public DebtorDto fromEntityToDto(Debtor debtor) {
        return DebtorDto.builder()
                .id(debtor.getId())
                .username(debtor.getUsername())
                .email(debtor.getEmail())
                .debts(debtor.getDebts())
                .build();
    }
}

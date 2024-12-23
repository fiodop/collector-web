package com.collectorWeb.service;

import com.collectorWeb.common.dto.DebtDTO;
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

    public DebtDTO addDebt(DebtDTO debtDTO) {
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
}

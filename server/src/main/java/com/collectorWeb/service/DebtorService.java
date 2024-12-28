package com.collectorWeb.service;

import com.collectorWeb.common.dto.DebtorDTO;
import com.collectorWeb.common.exceptions.DataDuplicationException;
import com.collectorWeb.model.entity.Debtor;
import com.collectorWeb.repository.DebtorRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DebtorService {
    private DebtorRepository debtorRepository;

    public DebtorDTO addDebtor(DebtorDTO debtorDTO) {
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

    public List<DebtorDTO> getDebtsByDebtor(int debtorId) {
        List<DebtorDTO> debtors = debtorRepository.getDebtorDTOById(debtorId);

        if(debtors.isEmpty()) {
            throw 
        }

    }


}

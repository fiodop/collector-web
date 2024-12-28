package com.collectorWeb.repository;

import com.collectorWeb.common.dto.DebtorDTO;
import com.collectorWeb.model.entity.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtorRepository extends JpaRepository<Debtor, Integer> {
    Debtor getDebtorByUsername(String username);
    List<DebtorDTO> getDebtorDTOById(int id);
}

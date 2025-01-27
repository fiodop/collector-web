package com.collectorWeb.repository;

import com.collectorWeb.model.dto.DebtorDto;
import com.collectorWeb.model.entity.Debt;
import com.collectorWeb.model.entity.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtorRepository extends JpaRepository<Debtor, Integer> {
    Debtor getDebtorByUsername(String username);
    List<DebtorDto> getDebtorsByAppUserId(long id);
    List<Debtor> findAll();
    Debtor getDebtorByDebtsContaining(Debt debt);
}

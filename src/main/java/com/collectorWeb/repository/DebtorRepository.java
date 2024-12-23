package com.collectorWeb.repository;

import com.collectorWeb.model.entity.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtorRepository extends JpaRepository<Debtor, Integer> {
    Debtor getDebtorByUsername(String username);
}

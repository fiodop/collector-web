package com.collectorWeb.repository;

import com.collectorWeb.model.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Integer> {
    public Debt deleteDebtById(int id);
    public Debt getDebtById(int id);
}

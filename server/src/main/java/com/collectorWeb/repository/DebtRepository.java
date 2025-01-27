package com.collectorWeb.repository;

import com.collectorWeb.model.entity.Debt;
import com.collectorWeb.model.entity.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Integer> {
    public Debt deleteDebtById(int id);
    public Debt getDebtById(int id);
    public List<Debt> findAll();
    
}

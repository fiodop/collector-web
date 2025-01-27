package com.collectorWeb.model.dto;

import com.collectorWeb.model.entity.Debt;
import com.collectorWeb.model.entity.Debtor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Builder
@Getter
@Setter
public class DebtorDto {
    private int id;
    private String username;
    private String email;
    private List<Debt> debts;

}

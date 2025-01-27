package com.collectorWeb.model.dto;

import com.collectorWeb.model.entity.Debt;
import com.collectorWeb.model.enums.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class DebtDto {
    private int id;
    private String title;
    private String debtorUsername;
    private int sum;
    private Currency currency;
    private String description;
    private LocalDateTime createdAt;
    private boolean notify;

//    public DebtDTO(boolean notify, String title, String debtorUsername, int sum, Currency currency, String description, LocalDateTime createdAt) {
//        this.notify = notify;
//        this.title = title;
//        this.debtorUsername = debtorUsername;
//        this.sum = sum;
//        this.currency = currency;
//        this.description = description;
//        this.createdAt = createdAt;
//    }

//    public DebtDto(Debt debt) {
//        this.id = debt.getId();
//        this.title = debt.getTitle();
//        this.sum = debt.getSum();
//        this.currency = debt.getCurrency();
//        this.description = debt.getDescription();
//        this.createdAt = debt.getCreatedAt();
//        this.notify = debt.isNotify();
//    }
}

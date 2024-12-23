package com.collectorWeb.common.dto;

import com.collectorWeb.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DebtDTO {
    private String title;
    private String debtorUsername;
    private int sum;
    private Currency currency;
    private String description;
    private Date createdAt;
    private boolean notify;
}

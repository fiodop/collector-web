package com.collectorWeb.model.dto;

import com.collectorWeb.model.entity.Debt;
import com.collectorWeb.service.DebtorService;


public class MailDto {
    private String to;
    private String subject;
    private String text;

    private static DebtorService debtorService;
    public MailDto(Debt debt) {
        this.to = debtorService.getDebtorByDebt(debt).getEmail();
        this.subject = subject;
        this.text = text;
        Boolean isHtml = false;
    }
}

package com.collectorWeb.common.dto;

import com.collectorWeb.model.entity.Debt;
import com.collectorWeb.model.entity.Debtor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class DebtorDTO {
    private int id;
    private String username;
    private String email;
    @Schema(required = false)
    private List<Debt> debts;

    public DebtorDTO(Debtor debtor) {
        this.username = debtor.getUsername();
        this.email = debtor.getEmail();
        this.debts = debtor.getDebts();
    }
}

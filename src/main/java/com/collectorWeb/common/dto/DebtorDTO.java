package com.collectorWeb.common.dto;

import com.collectorWeb.model.entity.Debt;
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
    private String username;
    private String email;
    @Schema(required = false)
    private List<Debt> debts;
}

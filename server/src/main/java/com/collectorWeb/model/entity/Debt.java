package com.collectorWeb.model.entity;

import com.collectorWeb.model.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Debt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "debtor_id", nullable = false)
    private Debtor debtor;
    private int sum;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
    private boolean notify;

}
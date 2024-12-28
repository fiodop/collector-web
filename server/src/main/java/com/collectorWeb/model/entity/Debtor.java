package com.collectorWeb.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Debtor {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true, nullable = false)
    private String username;
    private String email;
    @OneToMany
    @JoinColumn(name = "debtor_id")
    private List<Debt> debts;

}

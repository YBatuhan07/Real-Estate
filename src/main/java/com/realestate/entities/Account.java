package com.realestate.entities;

import com.realestate.enums.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {
    private String accountNo;
    private String iban;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
}

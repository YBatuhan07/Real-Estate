package com.realestate.entities;

import com.realestate.enums.CurrencyType;
import com.realestate.enums.HouseStatusType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class House extends BaseEntity {

    private Integer productionYear;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    @Enumerated(EnumType.STRING)
    private HouseStatusType status;
}

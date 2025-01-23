package com.realestate.dto;

import com.realestate.enums.CurrencyType;
import com.realestate.enums.HouseStatusType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DtoHouseIU {
    @NotNull
    private Integer productionYear;
    @NotNull
    private BigDecimal price;
    @NotNull
    private CurrencyType currency;
    @NotNull
    private HouseStatusType status;
}

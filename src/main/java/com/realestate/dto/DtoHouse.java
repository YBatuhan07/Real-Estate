package com.realestate.dto;

import com.realestate.enums.CurrencyType;
import com.realestate.enums.HouseStatusType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DtoHouse extends DtoBase{
    private Integer productionYear;
    private BigDecimal price;
    private CurrencyType currency;
    private HouseStatusType status;
}

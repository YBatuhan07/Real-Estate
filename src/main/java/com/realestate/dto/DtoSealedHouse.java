package com.realestate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSealedHouse extends DtoBase{
    private DtoRealEstateAgent realEstateAgent;
    private DtoHouse house;
    private DtoCustomer customer;
}

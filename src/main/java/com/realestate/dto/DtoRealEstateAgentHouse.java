package com.realestate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoRealEstateAgentHouse extends DtoBase{
    private DtoRealEstateAgent dtoRealEstateAgent;
    private DtoHouse dtoHouse;
}

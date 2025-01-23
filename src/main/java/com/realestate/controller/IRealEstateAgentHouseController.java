package com.realestate.controller;

import com.realestate.dto.DtoRealEstateAgentHouse;
import com.realestate.dto.DtoRealEstateAgentHouseIU;

public interface IRealEstateAgentHouseController {
    public RootEntity<DtoRealEstateAgentHouse> saveRealEstateAgentHouse(DtoRealEstateAgentHouseIU dtoRealEstateAgentHouseIU);
}

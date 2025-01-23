package com.realestate.service;

import com.realestate.dto.DtoRealEstateAgentHouse;
import com.realestate.dto.DtoRealEstateAgentHouseIU;

public interface IRealEstateAgentHouseService {
    public DtoRealEstateAgentHouse saveRealEstateAgentHouse(DtoRealEstateAgentHouseIU dtoRealEstateAgentHouseIU);
}

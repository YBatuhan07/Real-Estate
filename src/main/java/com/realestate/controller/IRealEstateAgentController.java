package com.realestate.controller;

import com.realestate.dto.DtoRealEstateAgent;
import com.realestate.dto.DtoRealEstateAgentIU;

public interface IRealEstateAgentController {
    public RootEntity<DtoRealEstateAgent> saveRealEstateAgent(DtoRealEstateAgentIU dtoRealEstateAgentIU);
}

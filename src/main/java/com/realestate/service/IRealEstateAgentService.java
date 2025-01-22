package com.realestate.service;

import com.realestate.dto.DtoRealEstateAgent;
import com.realestate.dto.DtoRealEstateAgentIU;

public interface IRealEstateAgentService {
    DtoRealEstateAgent saveRealEstateAgent(DtoRealEstateAgentIU dtoRealEstateAgentIU);
}

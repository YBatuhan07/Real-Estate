package com.realestate.service;

import com.realestate.dto.DtoSealedHouse;
import com.realestate.dto.DtoSealedHouseIU;

public interface ISoldHouseService {
    public DtoSealedHouse buyHouse(DtoSealedHouseIU dtoSealedHouseIU);
}

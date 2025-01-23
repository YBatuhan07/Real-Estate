package com.realestate.service;

import com.realestate.dto.DtoHouse;
import com.realestate.dto.DtoHouseIU;

public interface IHouseService {
    public DtoHouse saveHouse(DtoHouseIU dtoHouseIU);
}

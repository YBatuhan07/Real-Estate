package com.realestate.controller;

import com.realestate.dto.DtoHouse;
import com.realestate.dto.DtoHouseIU;

public interface IHouseController {
    public RootEntity<DtoHouse> saveHouse(DtoHouseIU dtoHouseIU);
}

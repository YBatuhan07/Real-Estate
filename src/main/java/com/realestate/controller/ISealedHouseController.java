package com.realestate.controller;

import com.realestate.dto.DtoSealedHouse;
import com.realestate.dto.DtoSealedHouseIU;

public interface ISealedHouseController {
    public RootEntity<DtoSealedHouse> buyCar(DtoSealedHouseIU dtoSealedHouseIU);
}

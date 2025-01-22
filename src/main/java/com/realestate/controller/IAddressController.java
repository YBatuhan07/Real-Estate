package com.realestate.controller;

import com.realestate.dto.DtoAddress;
import com.realestate.dto.DtoAddressIU;

public interface IAddressController {
    public RootEntity<DtoAddress> saveAddress(DtoAddressIU address);
}

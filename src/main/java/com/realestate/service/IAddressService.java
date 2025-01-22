package com.realestate.service;

import com.realestate.dto.DtoAddress;
import com.realestate.dto.DtoAddressIU;

public interface IAddressService {
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);

}

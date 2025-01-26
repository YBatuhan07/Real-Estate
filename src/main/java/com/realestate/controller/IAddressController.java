package com.realestate.controller;

import com.realestate.dto.DtoAddress;
import com.realestate.dto.DtoAddressIU;

import java.util.List;

public interface IAddressController {
    public RootEntity<DtoAddress> saveAddress(DtoAddressIU address);
    public RootEntity<DtoAddress> updateAddress(Long id, DtoAddressIU address);
    public RootEntity<DtoAddress> deleteAddress(Long id);
    public RootEntity<DtoAddress> getAddressById(Long id);
}

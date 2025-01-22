package com.realestate.controller;

import com.realestate.dto.DtoCustomer;
import com.realestate.dto.DtoCustomerIU;

public interface ICustomerController {
    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}

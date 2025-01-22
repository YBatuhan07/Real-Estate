package com.realestate.service;

import com.realestate.dto.DtoCustomer;
import com.realestate.dto.DtoCustomerIU;

public interface ICustomerService {
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}

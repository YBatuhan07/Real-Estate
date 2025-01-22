package com.realestate.controller;

import com.realestate.dto.DtoAccount;
import com.realestate.dto.DtoAccountIU;

public interface IAccountController {
    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}

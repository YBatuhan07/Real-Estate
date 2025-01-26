package com.realestate.service;

import com.realestate.dto.DtoAccount;
import com.realestate.dto.DtoAccountIU;

public interface IAccountService {
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
    public DtoAccount updateAccount(Long id, DtoAccountIU dtoAccountIU);
    public DtoAccount getAccountById(Long id);
    public DtoAccount deleteAccount(Long id);
}

package com.realestate.controller;

import com.realestate.dto.DtoAccount;
import com.realestate.dto.DtoAccountIU;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAccountController {
    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
    public RootEntity<DtoAccount> updateAccount(Long id, DtoAccountIU dtoAccountIU);
    public RootEntity<DtoAccount> deleteAccount(Long id);
    public RootEntity<DtoAccount> getAccountById(Long id);
}

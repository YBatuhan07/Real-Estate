package com.realestate.controller.concrete;

import com.realestate.controller.IAccountController;
import com.realestate.controller.RestBaseController;
import com.realestate.controller.RootEntity;
import com.realestate.dto.DtoAccount;
import com.realestate.dto.DtoAccountIU;
import com.realestate.service.IAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
public class AccountController extends RestBaseController implements IAccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {

        return ok(accountService.saveAccount(dtoAccountIU));
    }
    @PutMapping("/update/{id}")
    @Override
    public RootEntity<DtoAccount> updateAccount(@PathVariable(name = "id")Long id, @Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.updateAccount(id, dtoAccountIU));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<DtoAccount> deleteAccount(@Valid @PathVariable Long id) {
        return ok(accountService.deleteAccount(id));
    }
    @GetMapping("/getaccount/{id}")
    @Override
    public RootEntity<DtoAccount> getAccountById(@Valid @PathVariable Long id) {
        return ok(accountService.getAccountById(id));
    }
}

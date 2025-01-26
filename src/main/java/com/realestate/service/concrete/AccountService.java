package com.realestate.service.concrete;

import com.realestate.dto.DtoAccount;
import com.realestate.dto.DtoAccountIU;
import com.realestate.entities.Account;
import com.realestate.exception.BaseException;
import com.realestate.exception.ErrorMessage;
import com.realestate.exception.MessageType;
import com.realestate.repository.AccountRepository;
import com.realestate.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    private Account createAccount(DtoAccountIU dtoAccountIU){
        Account account = new Account();
        account.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoAccountIU, account);
        return account;
    }

    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
        DtoAccount dtoAccount = new DtoAccount();

        Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
        BeanUtils.copyProperties(savedAccount, dtoAccount);

        return dtoAccount;
    }

    @Override
    public DtoAccount updateAccount(Long id, DtoAccountIU dtoAccountIU) {
        DtoAccount dtoAccount = new DtoAccount();
        Optional<Account> optAccount = accountRepository.findById(id);
        if(optAccount.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,id + "'li kayıt bulunamadı."));
        }
        optAccount.get().setCreateTime(new Date());
        optAccount.get().setAccountNo(dtoAccountIU.getAccountNo());
        optAccount.get().setAmount(dtoAccountIU.getAmount());
        optAccount.get().setIban(dtoAccountIU.getIban());
        optAccount.get().setCurrencyType(dtoAccountIU.getCurrencyType());

        Account savedAccount = accountRepository.save(optAccount.get());

        BeanUtils.copyProperties(savedAccount, dtoAccount);
        return dtoAccount;
    }

    @Override
    public DtoAccount getAccountById(Long id) {
        DtoAccount dtoAccount = new DtoAccount();
        Optional<Account> optAccount = accountRepository.findById(id);
        if(optAccount.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,id.toString()));
        }
        BeanUtils.copyProperties(optAccount.get(), dtoAccount);
        return dtoAccount;
    }

    @Override
    public DtoAccount deleteAccount(Long id) {
        DtoAccount dtoAccount = new DtoAccount();
        Optional<Account> optAccount = accountRepository.findById(id);
        if(optAccount.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,id.toString()));
        }
        BeanUtils.copyProperties(optAccount.get(), dtoAccount);
        accountRepository.delete(optAccount.get());
        return dtoAccount;
    }
}

package com.realestate.service.concrete;

import com.realestate.exception.BaseException;
import com.realestate.exception.ErrorMessage;
import com.realestate.exception.MessageType;
import com.realestate.service.IAddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {
    public void test(){
//        throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,null));
    }
}

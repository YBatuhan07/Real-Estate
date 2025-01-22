package com.realestate.service.concrete;

import com.realestate.dto.DtoAddress;
import com.realestate.dto.DtoAddressIU;
import com.realestate.entities.Address;
import com.realestate.exception.BaseException;
import com.realestate.exception.ErrorMessage;
import com.realestate.exception.MessageType;
import com.realestate.repository.AddressRepository;
import com.realestate.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    private Address createAddress(DtoAddressIU dtoAddressIU) {
        Address address = new Address();
        address.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoAddressIU, address);

        return address;
    }
    private DtoAddress changeToDtoAddress(Address address) {
        DtoAddress dtoAddress = new DtoAddress();
        BeanUtils.copyProperties(address, dtoAddress);
        return dtoAddress;
    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));
        return changeToDtoAddress(savedAddress);
    }
}

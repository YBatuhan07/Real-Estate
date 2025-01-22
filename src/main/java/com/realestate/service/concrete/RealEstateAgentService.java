package com.realestate.service.concrete;

import com.realestate.dto.DtoAddress;
import com.realestate.dto.DtoRealEstateAgent;
import com.realestate.dto.DtoRealEstateAgentIU;
import com.realestate.entities.Address;
import com.realestate.entities.RealEstateAgent;
import com.realestate.exception.BaseException;
import com.realestate.exception.ErrorMessage;
import com.realestate.exception.MessageType;
import com.realestate.repository.AddressRepository;
import com.realestate.repository.RealEstateAgentRepository;
import com.realestate.service.IRealEstateAgentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RealEstateAgentService implements IRealEstateAgentService {

    @Autowired
    private RealEstateAgentRepository realEstateAgentRepository;
    @Autowired
    private AddressRepository addressRepository;

    private RealEstateAgent createRealEstateAgent(DtoRealEstateAgentIU dtoRealEstateAgentIU){
        RealEstateAgent realEstateAgent = new RealEstateAgent();
        BeanUtils.copyProperties(dtoRealEstateAgentIU, realEstateAgent);
        Optional<Address> optAddress = addressRepository.findById(dtoRealEstateAgentIU.getAddressId());
        if(optAddress.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoRealEstateAgentIU.getAddressId().toString()));
        }
        realEstateAgent.setAddress(optAddress.get());
        realEstateAgent.setCreateTime(new Date());

        return realEstateAgent;
    }

    @Override
    public DtoRealEstateAgent saveRealEstateAgent(DtoRealEstateAgentIU dtoRealEstateAgentIU) {
        DtoRealEstateAgent dtoRealEstateAgent = new DtoRealEstateAgent();
        DtoAddress dtoAddress = new DtoAddress();
        RealEstateAgent savedRealEstate = realEstateAgentRepository.save(createRealEstateAgent(dtoRealEstateAgentIU));
        BeanUtils.copyProperties(savedRealEstate, dtoRealEstateAgent);
        BeanUtils.copyProperties(savedRealEstate.getAddress(), dtoAddress);
        dtoRealEstateAgent.setDtoAddress(dtoAddress);
        return dtoRealEstateAgent;
    }
}

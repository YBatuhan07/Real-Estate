package com.realestate.service.concrete;

import com.realestate.dto.*;
import com.realestate.entities.House;
import com.realestate.entities.RealEstateAgent;
import com.realestate.entities.RealEstateAgentHouse;
import com.realestate.exception.BaseException;
import com.realestate.exception.ErrorMessage;
import com.realestate.exception.MessageType;
import com.realestate.repository.HouseRepository;
import com.realestate.repository.RealEstateAgentHouseRepository;
import com.realestate.repository.RealEstateAgentRepository;
import com.realestate.service.IRealEstateAgentHouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RealEstateAgentHouseService implements IRealEstateAgentHouseService {

    @Autowired
    private RealEstateAgentHouseRepository realEstateAgentHouseRepository;
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private RealEstateAgentRepository realEstateAgentRepository;

    public RealEstateAgentHouse createRealEstateAgentHouse(DtoRealEstateAgentHouseIU dtoRealEstateAgentHouseIU) {
        RealEstateAgentHouse realEstateAgentHouse = new RealEstateAgentHouse();

        Optional<House> optHouse = houseRepository.findById(dtoRealEstateAgentHouseIU.getHouseId());
        Optional<RealEstateAgent> optRealEstateAgent = realEstateAgentRepository.findById(dtoRealEstateAgentHouseIU.getRealEstateAgentId());

        if(optHouse.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoRealEstateAgentHouseIU.getHouseId().toString()));
        }
        if(optRealEstateAgent.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoRealEstateAgentHouseIU.getRealEstateAgentId().toString()));
        }

        realEstateAgentHouse.setHouse(optHouse.get());
        realEstateAgentHouse.setRealEstateAgent(optRealEstateAgent.get());
        realEstateAgentHouse.setCreateTime(new Date());
        return realEstateAgentHouse;
    }

    @Override
    public DtoRealEstateAgentHouse saveRealEstateAgentHouse(DtoRealEstateAgentHouseIU dtoRealEstateAgentHouseIU) {

        DtoRealEstateAgentHouse dtoRealEstateAgentHouse = new DtoRealEstateAgentHouse();

        DtoHouse dtoHouse = new DtoHouse();
        DtoRealEstateAgent dtoRealEstateAgent = new DtoRealEstateAgent();
        DtoAddress dtoAddress  = new DtoAddress();

        RealEstateAgentHouse realEstateAgentHouse = createRealEstateAgentHouse(dtoRealEstateAgentHouseIU);

        RealEstateAgentHouse saved = realEstateAgentHouseRepository.save(realEstateAgentHouse);

        BeanUtils.copyProperties(saved, dtoRealEstateAgentHouse);
        BeanUtils.copyProperties(saved.getRealEstateAgent(), dtoRealEstateAgent);
        BeanUtils.copyProperties(saved.getHouse(), dtoHouse);
        BeanUtils.copyProperties(saved.getRealEstateAgent().getAddress(), dtoAddress);

        dtoRealEstateAgent.setDtoAddress(dtoAddress);

        dtoRealEstateAgentHouse.setDtoHouse(dtoHouse);
        dtoRealEstateAgentHouse.setDtoRealEstateAgent(dtoRealEstateAgent);

        return dtoRealEstateAgentHouse;
    }
}

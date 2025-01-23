package com.realestate.service.concrete;

import com.realestate.dto.DtoHouse;
import com.realestate.dto.DtoHouseIU;
import com.realestate.entities.House;
import com.realestate.repository.HouseRepository;
import com.realestate.service.IHouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HouseService implements IHouseService {

    @Autowired
    private HouseRepository houseRepository;

    public House createHouse(DtoHouseIU dtoHouseIU) {
        House house = new House();
        BeanUtils.copyProperties(dtoHouseIU, house);
        house.setCreateTime(new Date());

        return house;
    }

    @Override
    public DtoHouse saveHouse(DtoHouseIU dtoHouseIU) {
        DtoHouse dtoHouse = new DtoHouse();

        House savedHouse = houseRepository.save(createHouse(dtoHouseIU));

        BeanUtils.copyProperties(savedHouse, dtoHouse);

        return dtoHouse;
    }
}

package com.realestate.controller.concrete;

import com.realestate.controller.IHouseController;
import com.realestate.controller.RootEntity;
import com.realestate.dto.DtoHouse;
import com.realestate.dto.DtoHouseIU;
import com.realestate.service.IHouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.realestate.controller.RootEntity.ok;

@RestController
@RequestMapping("/house")
public class HouseController implements IHouseController {

    @Autowired
    private IHouseService houseService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoHouse> saveHouse(@Valid @RequestBody DtoHouseIU dtoHouseIU) {
        return ok(houseService.saveHouse(dtoHouseIU));
    }
}

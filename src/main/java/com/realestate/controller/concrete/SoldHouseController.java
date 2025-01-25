package com.realestate.controller.concrete;

import com.realestate.controller.ISealedHouseController;
import com.realestate.controller.RestBaseController;
import com.realestate.controller.RootEntity;
import com.realestate.dto.DtoSealedHouse;
import com.realestate.dto.DtoSealedHouseIU;
import com.realestate.service.ISoldHouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/soldcar")
public class SoldHouseController extends RestBaseController implements ISealedHouseController {

    @Autowired
    private ISoldHouseService soldHouseService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoSealedHouse> buyCar(@Valid @RequestBody DtoSealedHouseIU dtoSealedHouseIU) {
        return ok(soldHouseService.buyHouse(dtoSealedHouseIU));
    }
}

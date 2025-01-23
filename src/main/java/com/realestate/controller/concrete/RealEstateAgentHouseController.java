package com.realestate.controller.concrete;

import com.realestate.controller.IRealEstateAgentHouseController;
import com.realestate.controller.RestBaseController;
import com.realestate.controller.RootEntity;
import com.realestate.dto.DtoRealEstateAgentHouse;
import com.realestate.dto.DtoRealEstateAgentHouseIU;
import com.realestate.service.IRealEstateAgentHouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/realestateagenthouse")
public class RealEstateAgentHouseController extends RestBaseController implements IRealEstateAgentHouseController {
    @Autowired
    private IRealEstateAgentHouseService realEstateAgentHouseService;

    @Override
    @PostMapping("/save")
    public RootEntity<DtoRealEstateAgentHouse> saveRealEstateAgentHouse(@Valid @RequestBody DtoRealEstateAgentHouseIU dtoRealEstateAgentHouseIU) {
        return ok(realEstateAgentHouseService.saveRealEstateAgentHouse(dtoRealEstateAgentHouseIU));
    }
}

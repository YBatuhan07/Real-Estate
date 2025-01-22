package com.realestate.controller.concrete;

import com.realestate.controller.IRealEstateAgentController;
import com.realestate.controller.RestBaseController;
import com.realestate.controller.RootEntity;
import com.realestate.dto.DtoRealEstateAgent;
import com.realestate.dto.DtoRealEstateAgentIU;
import com.realestate.service.IRealEstateAgentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/realEstateAgent")
public class RealEstateAgentController extends RestBaseController implements IRealEstateAgentController {

    @Autowired
    private IRealEstateAgentService realEstateAgentService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoRealEstateAgent> saveRealEstateAgent(@Valid @RequestBody DtoRealEstateAgentIU dtoRealEstateAgentIU) {

        return ok(realEstateAgentService.saveRealEstateAgent(dtoRealEstateAgentIU));
    }
}

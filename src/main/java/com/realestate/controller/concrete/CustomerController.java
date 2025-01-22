package com.realestate.controller.concrete;

import com.realestate.controller.ICustomerController;
import com.realestate.controller.RestBaseController;
import com.realestate.controller.RootEntity;
import com.realestate.dto.DtoCustomer;
import com.realestate.dto.DtoCustomerIU;
import com.realestate.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController extends RestBaseController implements ICustomerController {

    @Autowired
    private ICustomerService customerService;


    @PostMapping("/save")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }
}

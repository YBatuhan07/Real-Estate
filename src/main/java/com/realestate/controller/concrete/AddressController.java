package com.realestate.controller.concrete;

import com.realestate.controller.IAddressController;
import com.realestate.controller.RestBaseController;
import com.realestate.controller.RootEntity;
import com.realestate.dto.DtoAddress;
import com.realestate.dto.DtoAddressIU;
import com.realestate.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController extends RestBaseController implements IAddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU address) {
        return ok(addressService.saveAddress(address));
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<DtoAddress> updateAddress(@PathVariable Long id, @Valid @RequestBody DtoAddressIU dtoAddressIU) {
        return ok(addressService.updateAddress(id, dtoAddressIU));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<DtoAddress> deleteAddress(@PathVariable Long id) {
        return ok(addressService.deleteAddress(id));
    }

    @GetMapping("/getAddress/{id}")
    @Override
    public RootEntity<DtoAddress> getAddressById(@PathVariable(name = "id")Long id) {
        return ok(addressService.getAddressById(id));
    }
}

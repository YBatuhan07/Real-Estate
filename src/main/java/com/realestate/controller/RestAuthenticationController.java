package com.realestate.controller;

import com.realestate.dto.AuthRequest;
import com.realestate.dto.DtoUser;
import com.realestate.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticationController extends RestBaseController implements IRestAuthenticationController{

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {

        return ok(authenticationService.register(input));


    }
}

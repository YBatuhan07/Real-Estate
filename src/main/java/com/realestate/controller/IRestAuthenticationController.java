package com.realestate.controller;

import com.realestate.dto.AuthRequest;
import com.realestate.dto.DtoUser;

public interface IRestAuthenticationController {
    public RootEntity<DtoUser> register(AuthRequest input);
}

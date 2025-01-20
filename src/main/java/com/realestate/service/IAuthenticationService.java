package com.realestate.service;

import com.realestate.dto.AuthRequest;
import com.realestate.dto.DtoUser;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);

}

package com.realestate.service;

import com.realestate.dto.AuthRequest;
import com.realestate.dto.AuthResponse;
import com.realestate.dto.DtoUser;
import com.realestate.dto.RefreshTokenRequest;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);
    public AuthResponse authenticate(AuthRequest input);
    public AuthResponse refreshToken(RefreshTokenRequest input);

}

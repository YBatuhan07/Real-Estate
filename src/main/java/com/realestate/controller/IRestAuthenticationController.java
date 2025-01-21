package com.realestate.controller;

import com.realestate.dto.AuthRequest;
import com.realestate.dto.AuthResponse;
import com.realestate.dto.DtoUser;
import com.realestate.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {
    public RootEntity<DtoUser> register(AuthRequest input);
    public RootEntity<AuthResponse> authenticate(AuthRequest input);
    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}

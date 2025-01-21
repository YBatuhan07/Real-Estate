package com.realestate.service.concrete;

import com.realestate.dto.AuthRequest;
import com.realestate.dto.AuthResponse;
import com.realestate.dto.DtoUser;
import com.realestate.dto.RefreshTokenRequest;
import com.realestate.entities.RefreshToken;
import com.realestate.entities.User;
import com.realestate.exception.BaseException;
import com.realestate.exception.ErrorMessage;
import com.realestate.exception.MessageType;
import com.realestate.jwt.JwtService;
import com.realestate.repository.RefreshTokenRepository;
import com.realestate.repository.UserRepository;
import com.realestate.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private User createUser(AuthRequest input) {
        User user = new User();
        user.setCreateTime(new Date());
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return user;
    }

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setCreateTime(new Date());
        refreshToken.setExpiryDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 5));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return refreshToken;
    }

    @Override
    public DtoUser register(AuthRequest input) {
        DtoUser dtoUser = new DtoUser();
        User savedUser = userRepository.save(createUser(input));
        BeanUtils.copyProperties(savedUser, dtoUser);

        return dtoUser;
    }

    @Override
    public AuthResponse authenticate(AuthRequest input) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword());
            authenticationProvider.authenticate(authenticationToken);
            Optional<User> user = userRepository.findByUsername(input.getUsername());
            String accessToken = jwtService.generateToken(user.get());
            RefreshToken refreshToken = createRefreshToken(user.get());
            RefreshToken savedRefreshToken = refreshTokenRepository.save(refreshToken);

            return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());

        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID, e.getMessage()));
        }

    }

    public boolean isValidRefreshToken(Date expiredDate) {
        return new Date().before(expiredDate);
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest input) {

        Optional<RefreshToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(input.getRefreshToken());
        if (optRefreshToken.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND, input.getRefreshToken()));
        }

        if (!isValidRefreshToken(optRefreshToken.get().getExpiryDate())) {
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_IS_EXPIRED, input.getRefreshToken()));
        }
        User user = optRefreshToken.get().getUser();
        String accessToken = jwtService.generateToken(user);
        RefreshToken refreshToken = createRefreshToken(user);
        RefreshToken savedRefreshToken = refreshTokenRepository.save(refreshToken);

        return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
    }
}

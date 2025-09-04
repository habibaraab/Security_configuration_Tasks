package com.spring.task5.Service;

import com.spring.task5.DTOS.AuthenticationResponse;
import com.spring.task5.DTOS.LoginRequest;
import com.spring.task5.DTOS.Mapper.UserMapper;
import com.spring.task5.DTOS.UserRequestDto;
import com.spring.task5.Enum.TokenType;
import com.spring.task5.Model.Token;
import com.spring.task5.Model.User;
import com.spring.task5.Repository.TokenRepository;
import com.spring.task5.Repository.UserRepository;
import com.spring.task5.Security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder;
    private  final JwtService jwtService;

    private  final TokenRepository tokenRepository;

    private final AuthenticationManager authenticationManager;


    // This method is used to register a new user and generate a JWT token
    public AuthenticationResponse register(UserRequestDto request) {
        log.info("Attempting to register a new user with email: {}", request.getEmail());


        User user = userMapper.toUserEntity(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        log.debug("Saving the new user to the database...");
        User savedUser = userRepository.save(user);
        log.info("User with email {} registered successfully with ID: {}", savedUser.getEmail(), savedUser.getId());

        Map<String, Object> claims = new HashMap<>();

        log.debug("Generating access and refresh tokens for user ID: {}", savedUser.getId());
        String accessToken = jwtService.generateToken(savedUser, claims);
        String refreshToken = jwtService.generateRefreshToken(savedUser);

        saveUserToken(savedUser, accessToken);

        log.info("Registration process completed for user: {}", request.getEmail());
        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    // This method is used to authenticate the user and generate a JWT token
    public AuthenticationResponse login(LoginRequest request) {
        log.info("Login attempt for user: {}", request.getEmail());

        try {
            // Authenticate the user
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            log.info("Authentication successful for user: {}", request.getEmail());
        } catch (Exception e) {
            log.warn("Authentication failed for user: {}. Reason: {}", request.getEmail(), e.getMessage());
            throw e;
        }

        // If authentication is successful, generate a JWT token
        log.debug("Fetching user details from repository for token generation.");
        User user = userRepository.findUserByEmail(request.getEmail());
        Map<String, Object> claims = new HashMap<>();

        log.debug("Generating new tokens for user: {}", request.getEmail());
        String accessToken = jwtService.generateToken(user, claims);
        String refreshToken = jwtService.generateRefreshToken(user);

        // Save the token in the database
        saveUserToken(user, accessToken);

        log.info("Login process completed successfully for user: {}", request.getEmail());
        //  return two token in response
        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    // This method is used to save the JWT token in the database
    private void saveUserToken(User user, String jwtToken) {
        log.debug("Saving new token to database for user ID: {}", user.getId());
        // Create a new Token object
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        // Save the token in the database
        tokenRepository.save(token);
        log.debug("Token saved successfully.");
    }
}
package org.example.service;

import org.example.entities.RefreshToken; // Importing the RefreshToken entity
import org.example.entities.UserInfo; // Importing the UserInfo entity
import org.example.repository.RefreshTokenRepository; // Importing the RefreshTokenRepository
import org.example.repository.UserRepository; // Importing the UserRepository
import org.springframework.beans.factory.annotation.Autowired; // Importing the Autowired annotation
import org.springframework.stereotype.Service; // Importing the Service annotation

import java.time.Instant; // Importing the Instant class for time representation
import java.util.UUID; // Importing the UUID class for unique identifier generation

@Service // Indicates that this class is a service component in the Spring context
public class RefreshTokenService {

    @Autowired 
    private RefreshTokenRepository refreshTokenRepository; // Injecting the RefreshTokenRepository dependency

    @Autowired 
    private UserRepository userRepository; // Injecting the UserRepository dependency

    /**
     * Creates a new refresh token for the given username.
     * 
     * @param userName the username for which to create the refresh token
     * @return the created RefreshToken object
     */
    public RefreshToken createRefreshToken(String userName) {
        // Retrieve the UserInfo object for the given username
        UserInfo userInfoExtracted = userRepository.findByUsername(userName);
        
        // Create a new RefreshToken object using the builder pattern
        RefreshToken refreshToken = RefreshToken.builder()
                .userInfo(userInfoExtracted) // Associate the retrieved UserInfo with the refresh token
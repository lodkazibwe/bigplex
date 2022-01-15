package com.bigplex.bigplex.security;

import com.bigplex.bigplex.user.dto.ProfileDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private final String jwt;
    private ProfileDto profileDto;
}

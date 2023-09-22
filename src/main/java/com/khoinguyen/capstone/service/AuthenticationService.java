package com.khoinguyen.capstone.service;

import com.khoinguyen.capstone.model.dto.AuthenticationRequest;
import com.khoinguyen.capstone.model.dto.AuthenticationResponse;
import com.khoinguyen.capstone.model.dto.RegisterRequest;

public interface AuthenticationService {
    public AuthenticationResponse register(RegisterRequest request);

    public AuthenticationResponse authenticate(AuthenticationRequest request);
}

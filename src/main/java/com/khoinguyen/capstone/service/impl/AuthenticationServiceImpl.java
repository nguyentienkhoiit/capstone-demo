package com.khoinguyen.capstone.service.impl;

import com.khoinguyen.capstone.entity.Role;
import com.khoinguyen.capstone.entity.User;
import com.khoinguyen.capstone.model.dto.AuthenticationRequest;
import com.khoinguyen.capstone.model.dto.AuthenticationResponse;
import com.khoinguyen.capstone.model.dto.RegisterRequest;
import com.khoinguyen.capstone.repository.RoleRepository;
import com.khoinguyen.capstone.repository.UserRepository;
import com.khoinguyen.capstone.security.JwtService;
import com.khoinguyen.capstone.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationServiceImpl implements AuthenticationService {
    UserRepository repository;
    PasswordEncoder passwordEncoder;
    JwtService jwtService;
    AuthenticationManager authenticationManager;

    private AuthenticationResponse buildDTOAuthenticationResponse(User user) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Set<Role> set = user.getRoles();
        set.forEach(s -> authorities.add(new SimpleGrantedAuthority(s.getName())));
        var jwtToken = jwtService.generateToken(user, authorities);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(jwtToken)
                .build();
    }
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        user.setRoles(request.getRoles());
        user = repository.save(user);
        return buildDTOAuthenticationResponse(user);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return buildDTOAuthenticationResponse(user);
    }
}

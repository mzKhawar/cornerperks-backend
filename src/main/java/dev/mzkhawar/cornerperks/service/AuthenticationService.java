package dev.mzkhawar.cornerperks.service;

import dev.mzkhawar.cornerperks.config.JwtService;
import dev.mzkhawar.cornerperks.dto.AuthenticationRequest;
import dev.mzkhawar.cornerperks.dto.AuthenticationResponse;
import dev.mzkhawar.cornerperks.dto.RegisterRequest;
import dev.mzkhawar.cornerperks.model.Role;
import dev.mzkhawar.cornerperks.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userService.save(user);
        String jwtToken = jwtService.generateJwt(user);
        return AuthenticationResponse.builder()
                .jwt(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(@Valid AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        User user = userService.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String jwt = jwtService.generateJwt(user);
        return AuthenticationResponse.builder()
                .jwt(jwt)
                .build();
    }
}

package com.example.noodle.controller;

import com.example.noodle.config.JwtUtils;
import com.example.noodle.dto.AuthResponse;
import com.example.noodle.dto.AuthenticationRequest;
import com.example.noodle.model.User;
import com.example.noodle.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword()));
        System.out.println("Inainte de UserDetails");
        final UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        User tempUser = userRepository.findUserByEmail(user.getUsername()).orElse(null);
        System.out.println("Inainte de user != null");
        if (user != null) {
            return ResponseEntity.ok(new AuthResponse(jwtUtils.generateToken(user), tempUser.getRole().name()));
        }
        return ResponseEntity.status(400).body("Some error has occurred.");
    }
}

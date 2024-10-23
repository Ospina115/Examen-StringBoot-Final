package com.example.proyect.demo.application.services.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.proyect.demo.application.services.IUserService;
import com.example.proyect.demo.domain.dto.RegisterUser;
import com.example.proyect.demo.domain.dto.UserDto;
import com.example.proyect.demo.domain.dto.auth.AuthenticationRequest;
import com.example.proyect.demo.domain.dto.auth.AuthenticationResponse;
import com.example.proyect.demo.domain.entities.security.User;
import com.example.proyect.demo.infrastructure.utils.exeptions.ObjectNotFoundException;

@Service
public class AuthenticationService {

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public RegisterUser registerOneCustomer(UserDto newUser){
        User user = userService.registrOneCustomer(newUser);

        RegisterUser  userDto = new RegisterUser();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole().getName());

        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        userDto.setJwt(jwt);

        return userDto;
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims =new HashMap<>();
        extraClaims.put("name", user.getName());
        extraClaims.put("role", user.getRole().getName());
        extraClaims.put("authorities", user.getAuthorities());

        return extraClaims;
    }
    public AuthenticationResponse login(AuthenticationRequest autRequest) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            autRequest.getUsername(), autRequest.getPassword()
        );
        authenticationManager.authenticate(authentication);

        UserDetails user = userService.findOneByUsername(autRequest.getUsername()).get();
        String jwt  = jwtService.generateToken(user, generateExtraClaims((User) user));
        
        AuthenticationResponse authRsp = new AuthenticationResponse();
        authRsp.setJwt(jwt);

        return authRsp;
    }

    public boolean validateToken(String jwt) {
        try{
            jwtService.extractUsername(jwt);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public User findLoggedInUser() {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();

        return userService.findOneByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User not found. Username: " + username));
    }
}

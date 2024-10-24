package com.example.proyect.demo.infrastructure.repositories.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.proyect.demo.application.services.IRoleService;
import com.example.proyect.demo.application.services.IUserService;
import com.example.proyect.demo.domain.dto.UserDto;
import com.example.proyect.demo.domain.entities.security.User;
import com.example.proyect.demo.domain.entities.security.Role;
import com.example.proyect.demo.infrastructure.utils.exeptions.InvalidPasswordException;
import com.example.proyect.demo.infrastructure.utils.exeptions.ObjectNotFoundException;

@Service
public class UserImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRoleService roleService;

    @Override
    public User registrOneCustomer(UserDto newUser) {
        validatePassword(newUser);

        User user = new User();
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setUsername(newUser.getUsername());
        user.setName(newUser.getName());
        Role defaultRole = roleService.findDefaultRole()
                        .orElseThrow(() -> new ObjectNotFoundException("Role not found. Default Role"));
        user.setRole(defaultRole);

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    private void validatePassword(UserDto dto) {

        if(!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

        if(!dto.getPassword().equals(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

    }

}

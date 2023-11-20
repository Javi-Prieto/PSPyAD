package com.salesianos.dam.Example_for_Security.Service;

import com.salesianos.dam.Example_for_Security.DTO.UserDTO;
import com.salesianos.dam.Example_for_Security.model.User;
import com.salesianos.dam.Example_for_Security.model.UserRole;
import com.salesianos.dam.Example_for_Security.repo.UserRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepositorio repo;
    private final PasswordEncoder encoder;

    public User createuser(UserDTO userDTO, EnumSet<UserRole> roles){
        User user = User.builder()
                .username(userDTO.username())
                .password(encoder.encode(userDTO.passw()))
                .avatar(userDTO.avatar())
                .fullName(userDTO.fullName())
                .roles(roles)
                .build();
        return repo.save(user);
    }
    public User createUserWithUserRole(UserDTO userDTO){
        return createuser(userDTO, EnumSet.of(UserRole.USER));
    }
    public User createUserWithAdminRole(UserDTO userDTO){
        return createuser(userDTO, EnumSet.of(UserRole.ADMIN));
    }

    public List<User> findAll(){
        return repo.findAll();
    }
    public Optional<User> findById(UUID id){
        return repo.findById(id);
    }

    public Optional<User> findByUserName(String name){
        return repo.findFirstByUsername(name);
    }

    public Optional<User> edit(User user){
        return repo.findById(user.getId())
                .map(u -> {
                    u.setAvatar(user.getAvatar());
                    u.setFullName(user.getFullName());
                    return repo.save(u);
                });
    }

    public Optional<User> editPassword(UUID userId, String newPassw){
        return repo.findById(userId)
                .map(u -> {
                    u.setPassw(encoder.encode(newPassw));
                    return repo.save(u);
                });
    }

    public void deleteById(UUID id){
        if(repo.existsById(id))
            repo.deleteById(id);
    }

    public void delete(User user){
        deleteById(user.getId());
    }

}

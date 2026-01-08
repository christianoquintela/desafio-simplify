package com.example.desafio_simplify.service;


import com.example.desafio_simplify.auth.UserAuthenticated;
import com.example.desafio_simplify.entities.User;
import com.example.desafio_simplify.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public static UserAuthenticated authenticated() {
        try {
            return (UserAuthenticated) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
    //Tem melhor controle do que está acontecendo com a aplicação, ou faz tudo ou n faz nada.
    //Use em Create e Update
    @Transactional
    public User create(User obj) {
        obj.setId(null);
        obj.setPassword(this.bCryptPasswordEncoder.encode(obj.getPassword()));
        obj = this.userRepository.save(obj);
        return obj;
    }

}

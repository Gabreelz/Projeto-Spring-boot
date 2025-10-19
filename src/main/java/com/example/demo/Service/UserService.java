package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.exception.ObjectNotFoundException;
import com.example.demo.domain.User;




@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
            Optional<User> user = userRepository.findById(id);
            return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        }
}

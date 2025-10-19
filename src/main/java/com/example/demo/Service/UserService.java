package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.exception.ObjectNotFoundException;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;




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

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    public void updateData(User newObjt, User obj) {
        newObjt.setName(obj.getName());
        newObjt.setEmail(obj.getEmail());
    }
}

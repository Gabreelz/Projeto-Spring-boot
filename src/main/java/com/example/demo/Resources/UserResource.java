package com.example.demo.Resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.domain.User;
import com.example.dto.UserDTO;


@RestController
@RequestMapping(value="/users")
public class UserResource {
    
    @Autowired
    private UserService userService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
    System.out.println("Chamando userService.findAll()");
    List<User> list = userService.findAll();
    System.out.println("Lista retornada: " + list);
    List<UserDTO> listdto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listdto);
}
    
}

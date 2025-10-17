package com.example.demo.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.domain.User;


@RestController
@RequestMapping(value="/users")
public class UserResource {
    
    @Autowired
    private UserService userService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
    System.out.println("Chamando userService.findAll()");
    List<User> list = userService.findAll();
    System.out.println("Lista retornada: " + list);
    return ResponseEntity.ok().body(list);
}
    
}

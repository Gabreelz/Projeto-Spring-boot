package com.example.demo.Resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Service.UserService;
import com.example.demo.Service.exception.ObjectNotFoundException;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(value="/user")
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

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO objDto) {
        User obj = userService.fromDTO(objDto);
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();   
        return ResponseEntity.created(uri).build();
    }
    
    
}

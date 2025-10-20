package com.example.demo.Service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PostRepository;
import com.example.demo.Service.exception.ObjectNotFoundException;

@Service
public class PostService implements Serializable {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }
    
}

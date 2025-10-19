package com.example.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.domain.Post;
import com.example.demo.domain.User;

@Configuration
public class Instantiation implements CommandLineRunner {
    
    @Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... arg0) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User peter = new User(null, "Peter Parker", "clarim.diario@gmail.com");
		User logan = new User(null, "Logan", "x@gmail.com");
		User scott = new User(null, "Scott", "x@gmail.com");

		Post post1 = new Post(null, sdf.parse("19/10/2025"), "Amazing Fantasy", "Cabeça de teia", peter);
		Post post2 = new Post(null, sdf.parse("21/10/2025"), "Days of Future Past", "Wolverine", logan);

		
		userRepository.saveAll(Arrays.asList(peter, logan, scott));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}

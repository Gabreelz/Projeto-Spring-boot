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
import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.CommentsDTO;

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

		userRepository.saveAll(Arrays.asList(peter, logan, scott));

		Post post1 = new Post(null, sdf.parse("19/10/2025"), "Amazing Fantasy", "Cabeça de teia", new AuthorDTO(peter));
		Post post2 = new Post(null, sdf.parse("21/10/2025"), "Days of Future Past", "Wolverine", new AuthorDTO(peter));

		CommentsDTO c1 = new CommentsDTO("Boa postagem!", sdf.parse("20/10/2025"), new AuthorDTO(logan));
		CommentsDTO c2 = new CommentsDTO("Adorei!", sdf.parse("22/10/2025"), new AuthorDTO(scott));
		CommentsDTO c3 = new CommentsDTO("Muito legal!", sdf.parse("23/10/2025"), new AuthorDTO(logan));

		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));

		postRepository.saveAll(Arrays.asList(post1,post2));

		peter.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(peter);
	}
}

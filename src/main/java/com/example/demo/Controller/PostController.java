package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.PostEntity;
import com.example.demo.Repository.PostRepository;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/criar")
    public ResponseEntity<PostEntity> criarPost(@RequestParam String text, @RequestParam String url) {
        return ResponseEntity.ok(postRepository.save(new PostEntity(null, text, url)));

    }

    @GetMapping("/listar")
    public ResponseEntity<List<PostEntity>> listarPosts() {
        return ResponseEntity.ok(postRepository.findAll());
    }
}

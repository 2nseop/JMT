package com.sparta.project.controller;


import com.sparta.project.dto.PostRequestDto;
import com.sparta.project.entity.Post;
import com.sparta.project.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final com.sparta.project.service.PostService postService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/posts")
    public Post createMemo(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PutMapping("/api/posts/{id}/{password}")
    public Long updateMemo(@PathVariable Long id, @RequestBody PostRequestDto requestDto, @PathVariable String password) {
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/api/posts/{id}}")
    public Long deleteMemo(@PathVariable Long id) {
        return postService.deleteMemo(id);
    }

}
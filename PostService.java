package com.sparta.project.service;


import com.sparta.project.dto.MemberListRequestDto;
import com.sparta.project.dto.PostRequestDto;
import com.sparta.project.entity.MemberList;
import com.sparta.project.entity.Post;
import com.sparta.project.repository.MemberListRepository;
import com.sparta.project.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }

    @Transactional(readOnly = true)
    public List<Post> getPost() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }

    @Transactional
    public Long deletePost(Long id) {
        postRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Post JoinMember(MemberListRequestDto requestDto) {
        MemberList member = new MemberList(requestDto);
        MemberListRepository.save(member);
        return member;

    }
}

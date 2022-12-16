package com.sparta.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Post(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Post(com.sparta.project.dto.PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(com.sparta.project.dto.PostRequestDto memoRequestDto) {
        this.contents = memoRequestDto.getContents();
    }


}


package com.example.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

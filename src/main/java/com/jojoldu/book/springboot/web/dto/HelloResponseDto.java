package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //모든 필드의 Getter 생성
@RequiredArgsConstructor    //모든 final 필드를 인자로 생성자 생성. final 아니면 생성자 XXX
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
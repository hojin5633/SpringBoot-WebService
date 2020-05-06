package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        //assertj, 테스트 검증 라이브러리의 검증 메소드
        //검증하고 싶은 대상을 인자로 받아서 method chaining으로 isEqualsTo같은 메소드를 이어서 사용
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
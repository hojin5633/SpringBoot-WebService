package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //Controller가 JSON을 반환하도록
public class HelloController {

    @GetMapping("/hello")   //HTTP Get을 받도록
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {  //외부에서 API로 넘긴 파라미터를 가져오는 annotation
        //name(@RequestParam("name"))으로 넘기면 name(String name)으로 저장함
        return new HelloResponseDto(name, amount);
    }
}
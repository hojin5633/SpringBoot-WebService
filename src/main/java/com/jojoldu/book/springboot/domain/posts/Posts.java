package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entity class에는 Setter 메소드를 많들지 않는다!!!!!!!!!
//값을 Set하려면 특정 기능을 하는 메소드를 생성.
@Getter //롬복의 Annotation
@NoArgsConstructor  //롬복의 Annotation, 인자가 없는 생성자 생성
@Entity //JPA의 Annotation, Table과 Link될 Class임을 나타냄.
public class Posts extends BaseTimeEntity {
    @Id //테이블의 PK를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 Column 나타냄, 옵션 설정 기능
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    //Builder패턴 클래스
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
        
    }
}

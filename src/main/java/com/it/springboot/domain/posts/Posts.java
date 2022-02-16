package com.it.springboot.domain.posts;

import com.it.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //(6) 클래스 내 모든 필드의 Getter 메소드 자동생성
@NoArgsConstructor //(5) 기본 생성자 추가
@Entity //(1) 테이블과 링크 될 클래스
public class Posts extends BaseTimeEntity {

    @Id //(2) 해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //(3) PK의 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) //(4) 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //(7) 생성자에 포함된 필드만 빌더 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
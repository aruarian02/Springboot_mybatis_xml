package com.example.learn.data.entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Guestbook extends BaseEntity {
    private Long gno;

    private String title;
    private String content;
    private String writer;

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public void changeWriter(String writer) {
        this.writer = writer;
    }
}

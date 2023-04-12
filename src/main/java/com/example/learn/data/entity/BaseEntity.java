package com.example.learn.data.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
abstract class BaseEntity {
    private LocalDateTime regDate;

    private LocalDateTime modDate;
}

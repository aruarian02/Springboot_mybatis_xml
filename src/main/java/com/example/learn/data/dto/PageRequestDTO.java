package com.example.learn.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Data
@Builder
public class PageRequestDTO {

    // 현재 페이지 번호
    private int page;
    // 페이지 표시 개수
    private int size;

    public PageRequestDTO() {
        this(1, 10);
    }

    public PageRequestDTO(int page, int size) {
        this.page = page;
        this.size = size;
    }
}

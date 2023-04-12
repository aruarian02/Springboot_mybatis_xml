package com.example.learn.service;

import com.example.learn.data.dto.GuestbookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookServiceImplTest {

    @Autowired
    private GuestbookService guestbookService;

    @Test
    void register() {
        IntStream.rangeClosed(1, 300)
                .forEach(i -> {
                    GuestbookDTO dto = GuestbookDTO
                            .builder()
                            .title("Title..." + i)
                            .content("Content..." + i)
                            .writer("Writer..." + i)
                            .build();

//                    guestbookService.register(dto);
                });
    }

    @Test
    void testQuery() {
        guestbookService.guestbookList().forEach(System.out::println);

    }
}
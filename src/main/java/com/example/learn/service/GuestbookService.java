package com.example.learn.service;

import com.example.learn.data.dto.GuestbookDTO;
import com.example.learn.data.entity.Guestbook;

import java.util.List;

public interface GuestbookService {

    int register(GuestbookDTO dto);
    List<GuestbookDTO> guestbookList();
    GuestbookDTO getGuestbook(Long gno);
    void updateGuestbook(GuestbookDTO dto);
    void delete(Long gno);

    default Guestbook dtoToEntity(GuestbookDTO dto) {
        return Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }

    default GuestbookDTO entityToDto(Guestbook entity) {
        return GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
    }
}

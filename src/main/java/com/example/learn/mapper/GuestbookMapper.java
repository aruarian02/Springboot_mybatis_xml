package com.example.learn.mapper;

import com.example.learn.data.dto.GuestbookDTO;
import com.example.learn.data.entity.Guestbook;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GuestbookMapper {

    List<GuestbookDTO> getAll();
    Optional<Guestbook> getById(@Param("gno") Long gno);
    int insert(@Param("guestbook")Guestbook guestbook);
    void update(@Param("guestbook") Guestbook guestbook);
    void deleteById(@Param("gno") Long gno);
}

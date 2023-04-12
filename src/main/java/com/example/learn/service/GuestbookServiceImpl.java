package com.example.learn.service;

import com.example.learn.data.dto.GuestbookDTO;
import com.example.learn.data.entity.Guestbook;
import com.example.learn.mapper.GuestbookMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class GuestbookServiceImpl implements GuestbookService {

    @Autowired
    private GuestbookMapper guestbookMapper;

    @Override
    public int register(GuestbookDTO dto) {
        log.info("dto---------------" + dto);

        return guestbookMapper.insert(dtoToEntity(dto));
    }

    @Override
    public List<GuestbookDTO> guestbookList() {
        return guestbookMapper.getAll();
    }

    @Override
    public GuestbookDTO getGuestbook(Long gno) {
        log.info("gno-----------" + gno);
//        guestbookMapper.getById(gno).ifPresent(guestbook -> System.out.println(guestbook));
        return guestbookMapper.getById(gno).map(entity -> entityToDto(entity)).orElse(null);
    }

    @Override
    public void updateGuestbook(GuestbookDTO dto) {
        Optional<Guestbook> optGuestbook = guestbookMapper.getById(dto.getGno());

        optGuestbook.ifPresent(guestbook -> {
            guestbook.changeTitle(dto.getTitle());
            guestbook.changeContent(dto.getContent());
            guestbook.changeWriter(dto.getWriter());
            guestbookMapper.update(guestbook);
        });
    }

    @Override
    public void delete(Long gno) {
        Optional<Guestbook> optGuestbook = guestbookMapper.getById(gno);

        if (optGuestbook.isPresent()) {
            guestbookMapper.deleteById(gno);
        }
    }
}

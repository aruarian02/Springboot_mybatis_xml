package com.example.learn.controller;

import com.example.learn.data.dto.GuestbookDTO;
import com.example.learn.service.GuestbookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/guestbook")
@Log4j2
public class GuestbookController {

    @Autowired
    private GuestbookService guestbookService;

    @GetMapping("/list")
    public List<GuestbookDTO> guestbookList() {
        return guestbookService.guestbookList();
    }

    @GetMapping("{id}")
    public GuestbookDTO getGuestbook(@PathVariable Long id) throws Exception {
        GuestbookDTO guestbook = guestbookService.getGuestbook(id);

        if (guestbook == null) {
            log.info(id + "에 해당하는 guestbook이 존재하지 않습니다.");
            throw new Exception(id + "에 해당하는 guestbook이 존재하지 않습니다.");
        }

        return guestbook;
    }

    @PostMapping
    public void postGuestbook(@RequestBody GuestbookDTO guestbookDTO) {
        int result = guestbookService.register(guestbookDTO);

        log.info("GUESTBOOK " + result + " CREATED!!!");
    }

    @PostMapping("/update")
    public void updateGuestbook(@RequestBody GuestbookDTO guestbookDTO) {
        guestbookService.updateGuestbook(guestbookDTO);
    }

    @PostMapping("/delete")
    public void deleteGuestbook(@RequestBody Long gno) {
        guestbookService.delete(gno);
    }
}

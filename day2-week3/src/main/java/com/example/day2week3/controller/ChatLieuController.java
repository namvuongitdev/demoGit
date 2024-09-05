package com.example.day2week3.controller;

import com.example.day2week3.entity.ChatLieu;
import com.example.day2week3.mapper.ChatLieuMapper;
import com.example.day2week3.repository.ChatLieuRepository;
import com.example.day2week3.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/chat-lieu")
public class ChatLieuController {

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private ChatLieuMapper chatLieuMapper;

    @GetMapping("")
    public List<ChatLieu> getAll(){
        return chatLieuRepository.findAll();
    }


    @PostMapping("/add")
    public ChatLieu add(@RequestBody ChatLieu chatLieu){
         chatLieu.getSanPhams().forEach(o -> {
             sanPhamRepository.getOne(o.getId()).setChatLieu(chatLieu);
         });
        return chatLieuRepository.save(chatLieu);
    }
}

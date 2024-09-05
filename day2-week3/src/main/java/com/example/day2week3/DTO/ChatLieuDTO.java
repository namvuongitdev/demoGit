package com.example.day2week3.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatLieuDTO {
    private String id;
    private String tenChatLieu;
    private Integer trangThai;
    private List<SanPhamDTO> sanPhamDTOS = new ArrayList<>();
}

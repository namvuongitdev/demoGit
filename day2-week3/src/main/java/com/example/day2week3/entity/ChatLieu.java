package com.example.day2week3.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat_lieu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatLieu {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "ten_chat_lieu")
    private String tenChatLieu;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @OneToMany(mappedBy = "chatLieu" , targetEntity = SanPham.class ,cascade = {CascadeType.PERSIST ,CascadeType.MERGE , CascadeType.REMOVE , CascadeType.DETACH })
    private List<SanPham> sanPhams = new ArrayList<>();
}

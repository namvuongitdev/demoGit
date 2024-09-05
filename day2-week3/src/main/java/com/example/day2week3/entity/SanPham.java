package com.example.day2week3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "san_pham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "gia_ban")
    private Integer giaBan;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @ManyToOne(optional = false , targetEntity = ChatLieu.class, cascade = {CascadeType.PERSIST ,CascadeType.MERGE , CascadeType.REMOVE } , fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chat_lieu")
    private ChatLieu chatLieu;
}

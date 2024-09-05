package com.example.day2week3.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamDTO {

    private String id;
    private String tenSanPham;
    private Boolean gioiTinh;
    private String moTa;
    private Integer giaBan;
    private Integer trangThai;
    private ChatLieuDTO chatLieuDTO;
}

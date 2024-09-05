package com.example.day2week3.controller;

import com.example.day2week3.DTO.SanPhamDTO;
import com.example.day2week3.Service.MySerivce;
import com.example.day2week3.Service.SanPhamSerivce;
import com.example.day2week3.entity.SanPham;
import com.example.day2week3.mapper.SanPhamMapper;
import com.example.day2week3.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;


@RestController
@RequestMapping("/api/san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamSerivce sanPhamSerivce;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private MySerivce mySerivce;

    @Autowired
    private SanPhamMapper sanPhamMapper;


    @GetMapping("")
    public List<SanPhamDTO> getAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {

        return sanPhamMapper.sanPhamsToSanPhamDTOs(sanPhamRepository.testJoinFetch());
    }

    @PostMapping("/add")
    public SanPham add(@RequestBody SanPhamDTO sanPhamDTO) {
        return sanPhamSerivce.addService(sanPhamDTO);
    }

    @PutMapping("/update")
    public SanPhamDTO update(@RequestParam String id, @RequestBody SanPhamDTO sanPhamDTO) {
        return sanPhamSerivce.updateSanPham(sanPhamDTO, id);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String id) {
        return mySerivce.deleteSanPham(id);
    }
}

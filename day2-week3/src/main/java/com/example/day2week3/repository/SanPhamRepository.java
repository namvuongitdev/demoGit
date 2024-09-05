package com.example.day2week3.repository;

import com.example.day2week3.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham , String> {


    @Query(value = "select sp from SanPham sp join fetch sp.chatLieu cl")
    List<SanPham> testJoinFetch();
}

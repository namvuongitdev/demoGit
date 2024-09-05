package com.example.day2week3.mapper;

import com.example.day2week3.DTO.SanPhamDTO;
import com.example.day2week3.entity.SanPham;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring" , uses = {ChatLieuMapper.class})
public interface SanPhamMapper {

    @Mapping(source = "chatLieuDTO", target = "chatLieu")
    SanPham sanPhamDTOToSanPham(SanPhamDTO sanPhamDTO);

   @Mapping(source = "chatLieu", target = "chatLieuDTO")
   @Mapping(target = "chatLieuDTO.sanPhamDTOS" , ignore = true)
    SanPhamDTO sanPhamToSanPhamDTO(SanPham sanPham);

    @Mapping(target = "id" , ignore = true)
    @Mapping(source = "chatLieuDTO", target = "chatLieu")
    SanPham updateSanPhamDTOToSanPham(SanPhamDTO sanPhamDTO , @MappingTarget SanPham sanPham);

    List<SanPhamDTO> sanPhamsToSanPhamDTOs(List<SanPham> sanPhams);
}

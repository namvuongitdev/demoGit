package com.example.day2week3.mapper;

import com.example.day2week3.DTO.ChatLieuDTO;
import com.example.day2week3.entity.ChatLieu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatLieuMapper {

    @Mapping(source = "sanPhamDTOS" , target = "sanPhams")
    ChatLieu chatLieuDTOToChatLieu(ChatLieuDTO chatLieuDTO);

    @Mapping(source = "sanPhams" , target = "sanPhamDTOS")
    ChatLieuDTO chatLieuToChatLieuDTO(ChatLieu chatLieu);

    List<ChatLieuDTO> chatLieuDTOSTochatLieus(List<ChatLieu> chatLieus);

    @Mapping(target = "id" , ignore = true)
    ChatLieu updateChatLieuDTOToChatLieu(ChatLieuDTO chatLieuDTO , @MappingTarget ChatLieu chatLieu);
}

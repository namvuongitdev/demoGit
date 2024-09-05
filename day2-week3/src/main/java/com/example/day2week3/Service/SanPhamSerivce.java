package com.example.day2week3.Service;

import com.example.day2week3.DTO.SanPhamDTO;
import com.example.day2week3.entity.SanPham;
import com.example.day2week3.exception.MyCustomException;
import com.example.day2week3.mapper.SanPhamMapper;
import com.example.day2week3.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class SanPhamSerivce {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamMapper sanPhamMapper;

    @Autowired
    private SanPhamSerivce sanPhamSerivce;

    @Autowired
    private MySerivce mySerivce;

    public SanPham getOneService(String id) {
        return sanPhamRepository.findById(id).orElseThrow(() -> new RuntimeException("san pham not found"));
    }

    @Transactional(readOnly = true)
    public List<SanPhamDTO> sanPhamDTOS(Pageable pageable) {
        List<SanPham> sanPhams = sanPhamRepository.findAll(pageable).getContent();
        return sanPhamMapper.sanPhamsToSanPhamDTOs(sanPhams);
    }

    @Transactional
    public SanPham addService(SanPhamDTO sanPhamDTO){
        SanPham sanPham = sanPhamMapper.sanPhamDTOToSanPham(sanPhamDTO);
        SanPham sp = sanPhamRepository.save(sanPham);
        //propagation = Propagation.REQUIRED
        try {
            mySerivce.deleteSanPham("682a747d-4dd7-4f4b-a486-92621dc22a63");
        } catch (MyCustomException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Transactional(rollbackFor = {Exception.class})
//    @Transactional(noRollbackFor = {Exception.class})
    public SanPhamDTO updateSanPham(SanPhamDTO sanPhamDTO, String id) {
        Optional<SanPham> sanPhamOptional = sanPhamRepository.findById(id);
        if (sanPhamOptional.isPresent()) {
            SanPham sanPham = sanPhamMapper.updateSanPhamDTOToSanPham(sanPhamDTO, sanPhamOptional.get());
            return sanPhamMapper.sanPhamToSanPhamDTO(sanPhamRepository.save(sanPham));
        } else {
            throw new RuntimeException("sản phẩm không tồn tại");
        }
    }

    @Transactional
    public void executeMainOperation() {
        // Phương thức chính bắt đầu một giao dịch
        System.out.println("abadadad");
        // Gọi phương thức phụ thuộc mà phải được thực hiện trong một giao dịch hiện tại
        mySerivce.performDependentOperation();
    }

}

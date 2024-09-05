package com.example.day2week3.Service;

import com.example.day2week3.entity.SanPham;
import com.example.day2week3.exception.MyCustomException;
import com.example.day2week3.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MySerivce {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Transactional(propagation = Propagation.MANDATORY)
    // phương thức chỉ được thực hiện trong một phương thức có giao dịch hiện tại nếu không khi chạy sẽ ném ra ngoại lệ
    public void performDependentOperation() {
        // Phương thức này phải được thực hiện trong một giao dịch hiện tại
        System.out.println("12312321312321");
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = {"MyCustomException"})
    public String deleteSanPham(String id)  {
        Optional<SanPham> sanPhamOptional = sanPhamRepository.findById(id);

            throw new MyCustomException("sản phẩm không tồn tại");
    }
}

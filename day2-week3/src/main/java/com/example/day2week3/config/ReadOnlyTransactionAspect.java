package com.example.day2week3.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class ReadOnlyTransactionAspect {
//    private static final Logger logger = LoggerFactory.getLogger(ReadOnlyTransactionAspect.class);
//
//    @Pointcut("@annotation(transactional)")
//    public void transactionalMethods(Transactional transactional) {}
//
//    @AfterReturning(pointcut = "transactionalMethods(transactional)")
//    public void checkReadOnly(JoinPoint joinPoint, Transactional transactional) {
//        if (transactional.readOnly()) {
//            // Giả sử rằng tất cả các phương thức `readOnly` đều không thực hiện ghi dữ liệu
//            // Nếu có một cơ chế cụ thể để kiểm tra, thêm vào đây
//            logger.warn("Phương thức {} đánh dấu là readOnly nhưng có thể thực hiện thao tác ghi dữ liệu", joinPoint.getSignature().getName());
//        }
//    }
}

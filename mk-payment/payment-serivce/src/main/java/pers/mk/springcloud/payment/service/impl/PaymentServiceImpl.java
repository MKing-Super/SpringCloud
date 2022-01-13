package pers.mk.springcloud.payment.service.impl;

import org.springframework.stereotype.Service;
import pers.mk.springcloud.payment.mapper.PaymentMapper;
import pers.mk.springcloud.payment.model.Payment;
import pers.mk.springcloud.payment.service.PaymentService;

import javax.annotation.Resource;

@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}

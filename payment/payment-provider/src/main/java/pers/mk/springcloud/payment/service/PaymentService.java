package pers.mk.springcloud.payment.service;

import org.apache.ibatis.annotations.Param;
import pers.mk.springcloud.payment.model.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}

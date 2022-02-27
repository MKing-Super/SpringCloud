package pers.mk.springcloud.payment.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.mk.springcloud.payment.model.Payment;

@Mapper
public interface PaymentMapper {
    public int create(Payment payment);

    public Payment  getPaymentById(@Param("id")Long id);
}

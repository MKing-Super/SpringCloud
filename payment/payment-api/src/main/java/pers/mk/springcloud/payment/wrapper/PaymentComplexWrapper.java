package pers.mk.springcloud.payment.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.mk.springcloud.payment.model.Order;
import pers.mk.springcloud.payment.model.Payment;

/**
 * @Description: 封装类
 * @Author: kun.ma
 * @Date: 2022/3/2 16:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentComplexWrapper {
    private Payment payment;
    private Order order;

}

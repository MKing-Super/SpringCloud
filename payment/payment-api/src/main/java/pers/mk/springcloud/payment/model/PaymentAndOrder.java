package pers.mk.springcloud.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 支付和订单综合
 * @Author: kun.ma
 * @Date: 2022/3/1 14:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAndOrder {
    private Payment payment;
    private Order order;
}

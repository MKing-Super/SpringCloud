package pers.mk.springcloud.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 支付和订单综合
 * @Author: kun.ma
 * @Date: 2022/3/1 14:15
 */
public class PaymentAndOrder implements Serializable {
    private Payment payment;
    private Order order;

    public PaymentAndOrder() {
    }

    public PaymentAndOrder(Payment payment, Order order) {
        this.payment = payment;
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

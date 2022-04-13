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
public class PaymentComplexWrapper {
    private Payment payment;
    private Order order;

    public PaymentComplexWrapper(Payment payment, Order order) {
        this.payment = payment;
        this.order = order;
    }

    public PaymentComplexWrapper() {
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

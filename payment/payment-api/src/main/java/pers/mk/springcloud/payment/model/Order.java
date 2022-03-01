package pers.mk.springcloud.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 订单
 * @Author: kun.ma
 * @Date: 2022/3/1 13:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private String userName;
    private String password;
}

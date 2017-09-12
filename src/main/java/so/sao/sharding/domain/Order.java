package so.sao.sharding.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Create by wuxingxing on 2017/8/21 16:05
 */
@Data
public class Order {
    //    private Long shopId;
//    private Integer channel;
//    private Integer type;
//    private Integer status;
//    private BigDecimal subtotal;
//    private BigDecimal savings;
//    private BigDecimal grandTotal;
//    private Integer paymentType;
//    private Integer paymentMethod;
//    private String buyerId;
//    private Long padOrderTime;
    private Integer orderId;
    private Integer userId;
    private String status;
}

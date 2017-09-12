package so.sao.sharding.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import so.sao.sharding.domain.Order;

import java.util.List;

/**
 * Create by wuxingxing on 2017/8/21 16:17
 */
@Mapper
public interface OrderMapper {

    List<Order> findAll();

    Order findById(@Param("id") Integer id);

    void insert(Order order);

    List<Order> findAllOrders();
}

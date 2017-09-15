package so.sao.sharding.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import so.sao.sharding.domain.Order;
import so.sao.sharding.mapper.OrderMapper;

import java.util.List;

/**
 * Create by wuxingxing on 2017/8/21 16:42
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

//    public PageInfo<Order> findAll(){
//        return PageHelper.startPage(1, 2).doSelectPageInfo(() -> orderMapper.findAll());
//    }

    public Order findById(Integer id){
        return orderMapper.findById(id);
    }

    public void save(Order order) {
        orderMapper.insert(order);
    }

    public List<Order> findAll(){
        return orderMapper.findAllOrders();
    }

    public Order insert(){
        Order order = new Order();
        order.setUserId(1);
        order.setStatus("1");
        order.setOrderId(1);
        orderMapper.insert(order);
        return order;
    }
}

package so.sao.sharding.controller;

import com.dangdang.ddframe.rdb.sharding.api.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import so.sao.sharding.domain.Order;
import so.sao.sharding.service.OrderService;

import java.util.List;

/**
 * Create by wuxingxing on 2017/8/21 16:43
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @RequestMapping(value = "/{id}")
    public Order findById(@PathVariable Integer id) {
        HintManager.getInstance().setMasterRouteOnly();
        return orderService.findById(id);
    }

    @RequestMapping(value = "/insert")
    public Order insert(){
       return orderService.insert();
    }
}

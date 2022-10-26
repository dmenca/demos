package com.dmenca.spb.controller;

import com.dmenca.spb.entity.Order;
import com.dmenca.spb.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/testAdd")
    public void testAddOrder(){
        for (int i =0;i<10;i++){
            Order order = new Order();
            order.setOrderNo("ABCDEFG-"+i);
            order.setPrice(25.2F);
            order.setCreateName("test");
            orderMapper.insert(order);
        }
    }
}

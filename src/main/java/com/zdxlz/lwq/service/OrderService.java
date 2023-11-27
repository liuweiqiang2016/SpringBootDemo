package com.zdxlz.lwq.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zdxlz.lwq.enity.Order;
import com.zdxlz.lwq.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    //插入默认数据源
    public void insertDB1(int price,int user_id){
        Order order=new Order();
        BigDecimal order_id=new BigDecimal(new Random().nextInt(999999));
        order.setOrderId(order_id);
        order.setPrice(price);
        order.setUserId(user_id);
        order.setStatus("SUCCESS");
        order.setCreateDate(new Date());
        orderMapper.insert(order);
    }

    //插入 DB2
    @DS("db2")
    public void insertDB2(int price,int user_id){
        Order order=new Order();
        BigDecimal order_id=new BigDecimal(new Random().nextInt(999999));
        order.setOrderId(order_id);
        order.setPrice(price);
        order.setUserId(user_id);
        order.setStatus("SUCCESS");
        order.setCreateDate(new Date());
        orderMapper.insert(order);
    }

    //对指定列的值去重
    public List<Object> distinctParam(String param){
        return orderMapper.distinctParam(param);
    }

    //计算指定列的数值总和
    public List<Object> sumParam(String param){
       return orderMapper.sumParam(param);
    }

    //将指定列进行拼接
    public List<Object> concatInfo(String param1,String param2){
      return orderMapper.concatInfo(param1,param2);
    }

    //将指定列以"#"进行拼接
    public List<Object> concatwsInfo(String param1,String param2){
       return orderMapper.concatwsInfo(param1,param2);
    }

    //判断指定列是否为null，不为null返回第一个参数，为null返回第二个参数
    public List<Object> ifnullParam(String param1,String param2){
       return orderMapper.ifnullParam(param1,param2);
    }

    //统计指定列出现的次数，并对该列进行分组
    public List<Map<Object,Object>> groupByParam(String param){
      return orderMapper.groupByParam(param);
    }

    //与聚合函数一起使用的判断语句 having
    public List<Object> havingParam(String param1,String param2){
        return orderMapper.havingParam(param1,param2);
    }

    //查询两张表所有param不同的数据，相同的param去重
    public List<Object> unionParam(String param){
        return orderMapper.unionParam(param);
    }

    //查询两张表所有param的数据
    public List<Object> unionallParam(String param){
        return orderMapper.unionallParam(param);
    }

}

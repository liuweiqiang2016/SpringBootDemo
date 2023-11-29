package com.zdxlz.lwq.controller;

import com.zdxlz.lwq.enity.User;
import com.zdxlz.lwq.service.GradeService;
import com.zdxlz.lwq.service.OrclService;
import com.zdxlz.lwq.service.OrderService;
import com.zdxlz.lwq.service.PgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
//定义Controller路径
//@RequestMapping("my")
public class MyController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PgService pgService;
    @Autowired
    private OrclService orclService;

   @GetMapping("test")
    public String helloWorld(){
        return "hello world:"+new Date();
    }

    @RequestMapping(value ="/getInfo",method = RequestMethod.GET)
    public User getInfo(User user){
        return user;
    }


//    @RequestMapping(value = "/seedInfo",method = RequestMethod.POST)
    @PostMapping("seedInfo")
//    @GetMapping("seedInfo")
    public User seedInfo(User user){
        return user;
    }

    @PostMapping("insertMsg")
    public String insertMsg(String p_id,int score,String level){
       gradeService.insertMsg(p_id,score,level);
       return "mysql 插入成绩:"+new Date();
    }

    @PostMapping("deleteMsgByID")
    public String deleteMsgByID(int id){
        gradeService.deleteMsgByID(id);
        return "mysql 删除成绩:"+new Date();
    }
    @PostMapping("deleteMsgByMap")
    public String deleteMsgByMap(String key,String value){
       gradeService.deleteMsgByMap(key,value);
        return "mysql 删除一组成绩:"+new Date();
    }


    @PostMapping("insertPg")
    public String insertPg(String p_id,int score,String level){
        pgService.insertMsg(p_id,score,level);
        return "pg 数据库插入成绩:"+new Date();
    }

    @PostMapping("deletePgByID")
    public String deletePgByID(int id){
        pgService.deleteMsgByID(id);
        return "pg 删除成绩:"+new Date();
    }
    @PostMapping("deletePgByMap")
    public String deletePgByMap(String key,String value){
        pgService.deleteMsgByMap(key,value);
        return "pg 删除一组成绩:"+new Date();
    }


    @PostMapping("insertOrcl")
    public String insertOrcl(String p_id,int score,String level){
        orclService.insertMsg(p_id,score,level);
        return "Oracle 数据库插入成绩:"+new Date();
    }

    @PostMapping("deleteOrclByID")
    public String deleteOrclByID(int id){
        orclService.deleteMsgByID(id);
        return "Oracle 删除成绩:"+new Date();
    }
    @PostMapping("deleteOrclByMap")
    public String deleteOrclByMap(String key,String value){
        orclService.deleteMsgByMap(key,value);
        return "Oracle 删除一组成绩:"+new Date();
    }


    @PostMapping("insertDB1")
    public String insertDB1(int price,int user_id){
       orderService.insertDB1(price,user_id);
       return "插入默认数据库DB1:"+new Date();
    }

    @PostMapping("insertDB2")
    public String insertDB2(int price,int user_id){
        orderService.insertDB2(price,user_id);
        return "插入数据库DB2:"+new Date();
    }

    @PostMapping("sumParam")
    public List<Object> sumParam(String param){
       return orderService.sumParam(param);
    }

    @PostMapping("concatInfo")
    public List<Object> concatInfo(String param1,String param2){
       return orderService.concatInfo(param1,param2);
    }

    @PostMapping("concatwsInfo")
    public List<Object> concatwsInfo(String param1,String param2){
        return orderService.concatwsInfo(param1,param2);
    }

    @PostMapping("distinctParam")
    public List<Object> distinctParam(String param){
       return orderService.distinctParam(param);
    }

    @PostMapping("ifnullParam")
    public List<Object> ifnullParam(String param1,String param2){
        return orderService.ifnullParam(param1,param2);
    }

    @PostMapping("groupByParam")
    public List<Map<Object,Object>> groupByParam(String param){
        return orderService.groupByParam(param);
    }

    @PostMapping("havingParam")
    public List<Object> havingParam(String param1,String param2){
       return orderService.havingParam(param1,param2);
    }
    @PostMapping("unionParam")
    public List<Object> unionParam(String param){
        return orderService.unionParam(param);
    }

    @PostMapping("unionallParam")
    public List<Object> unionallParam(String param){
        return orderService.unionallParam(param);
    }
}

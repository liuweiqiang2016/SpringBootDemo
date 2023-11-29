package com.zdxlz.lwq.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zdxlz.lwq.enity.Grade;
import com.zdxlz.lwq.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@DS("orcldb")
public class OrclService {
    @Autowired
    GradeMapper gradeMapper;
    public void insertMsg(String p_id,int score,String level){
        Grade grade=new Grade();
        grade.setpId(p_id);
        grade.setScore(score);
        grade.setLevel(level);
        //插入一条新数据
        gradeMapper.insertGrade(grade);
        //直接使用mybatis-plus提供给的insert接口,执行的SQL为 insert into grade(id,p_id,score,level) values (?,?,?,?)
        //其中id没有设置，取默认值0,所有sql语句的id均为0，导致sql插入失败，pg提示违反唯一约束，mysql不会
        //因此这里自定义insert处理逻辑，而不能使用默认的insert接口
        //gradeMapper.insert(grade);
    }
    public void deleteMsgByID(int id){
        //根据主键删除数据
        gradeMapper.deleteById(id);
    }
    public void deleteMsgByMap(String key,String value){
        //根据条件删除数据
        Map<String,Object> map=new HashMap<>();
        map.put(key,value);
        gradeMapper.deleteByMap(map);
    }

}

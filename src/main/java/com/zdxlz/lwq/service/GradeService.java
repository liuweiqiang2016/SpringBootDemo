package com.zdxlz.lwq.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zdxlz.lwq.enity.Grade;
import com.zdxlz.lwq.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
@DS("mydb")
public class GradeService {
    @Autowired
    GradeMapper gradeMapper;
    public void insertMsg(String p_id,int score,String level){
        Grade grade=new Grade();
        grade.setpId(p_id);
        grade.setScore(score);
        grade.setLevel(level);
        //插入一条新数据
        gradeMapper.insert(grade);
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

package com.zdxlz.lwq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdxlz.lwq.enity.Grade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GradeMapper extends BaseMapper<Grade> {
    @Insert("insert into grade(p_id,score,level) values ( #{grade.pId},#{grade.score},#{grade.level})")
    public void insertGrade(@Param("grade")Grade grade);
}

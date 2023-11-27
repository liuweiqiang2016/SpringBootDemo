package com.zdxlz.lwq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdxlz.lwq.enity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select distinct ${param} from t_order_1")
    public List<Object> distinctParam(String param);

    @Select("select sum(${param}) from t_order_1")
    public List<Object> sumParam(@Param("param") String param);

    @Select("select concat(${param1},${param2}) as user_info from t_order_1")
    public List<Object> concatInfo(@Param("param1")String param1,@Param("param2")String param2);

    @Select("select concat_ws('#',${param1},${param2}) as user_info from t_order_1")
    public List<Object> concatwsInfo(@Param("param1")String param1,@Param("param2")String param2);

    @Select("select ifnull(${param1},${param2}) as user_info from t_order_1")
    public List<Object> ifnullParam(@Param("param1")String param1,@Param("param2")String param2);

    @Select("select ${param},count(*) from t_order_1 group by ${param}")
    public List<Map<Object,Object>> groupByParam(@Param("param") String param);

    @Select("select ${param1} from t_order_1 group by ${param1} having sum(${param2})>500")
    public List<Object> havingParam(@Param("param1")String param1,@Param("param2")String param2);

    @Select("select ${param} from t_order_1 union select ${param} from t_order_2 order by ${param}")
    public List<Object> unionParam(@Param("param")String param);

    @Select("select ${param} from t_order_1 union all select ${param} from t_order_2 order by ${param}")
    public List<Object> unionallParam(@Param("param")String param);

}

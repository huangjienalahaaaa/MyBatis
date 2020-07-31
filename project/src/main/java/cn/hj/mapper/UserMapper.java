package cn.hj.mapper;

import cn.hj.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

//    UserMapper接口编写方法
    @Select(value="select * from user where id = #{uid}")
    public User findById(Integer uid);

}

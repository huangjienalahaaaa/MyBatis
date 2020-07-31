package cn.hj.mapper;

import cn.hj.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    public List<User> findById();

    public List<User> findAllLazy();

    /*查询所有的用户:
    *
    *   1. @Select:
    *           1. @Select(value = {"",""})  多个值的写法
    *           2. @Select(value = "")  只有一个值的写法
    *
    *       注意，values属性是可以省略不写的：既"value =" 是可以不写的
    * */
    @Select("select * from user")
    public List<User> findAll();
}

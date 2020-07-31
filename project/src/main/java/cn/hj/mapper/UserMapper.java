package cn.hj.mapper;

import cn.hj.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {

    @Select(value="select * from user")
    @Results(id="userMap",value= {
            @Result(id=true,column="id",property="id"),
            @Result(column="username",property="username"),
            @Result(column="birthday",property="birthday"),
            @Result(column="sex",property="sex"),
            @Result(column="address",property="address"),
            @Result(property="accounts",column="id",many=@Many(select="cn.tx.mapper.AccountMapper.findByUid",fetchType= FetchType.LAZY))
    })
    public List<User> findAll();
}

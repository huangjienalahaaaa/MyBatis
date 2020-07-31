package cn.hj.mapper;

import cn.hj.domain.Account;
import cn.hj.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;


public interface AccountMapper {
    /**
     * 延迟加载
     * @return
     */
    @Select("select * from account")

    /**
     *  1. one= :  这里是多对一查询，查询的是一个用户对象，所以下面选择one。如果是一对多，下面应该选择many
     *  2. column= : column是表示 你要将哪个值传递给后面one里面的sql语句
     */
    @Results(value= {
            @Result(id=true,column="aid",property="id"),
            @Result(column="uid",property="uid"),
            @Result(column="money",property="money"),
            @Result(property="user",javaType= User.class,column="uid",one=@One(select="cn.hj.mapper.UserMapper.findById",fetchType= FetchType.LAZY))
    })
    public List<Account> findAll();

    public List<Account> findAllLazy();

    public List<Account> findByUid(int uid);


}

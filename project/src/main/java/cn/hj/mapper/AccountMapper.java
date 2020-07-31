package cn.hj.mapper;

import cn.hj.domain.Account;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface AccountMapper {
    /**
     * 立即加载
     * @return
     */
    @Select("SELECT a.ID AS aid,a.UID,a.MONEY,u.* FROM account a,USER u WHERE a.UID = u.id")
    @Results(value= {
            @Result(id=true,column="aid",property="id"),
            @Result(column="uid",property="uid"),
            @Result(column="money",property="money"),
            @Result(column="id",property="user.id"),
            @Result(column="username",property="user.username"),
            @Result(column="birthday",property="user.birthday"),
            @Result(column="sex",property="user.sex"),
            @Result(column="address",property="user.address")
    })
    public List<Account> findAll();

    public List<Account> findAllLazy();

    public List<Account> findByUid(int uid);


}

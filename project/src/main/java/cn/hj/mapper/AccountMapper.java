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
    //AccountMapper接口提供方法
    @Select("select * from account where uid = #{uid}")
    public List<Account> findByUserId(Integer uid);

}

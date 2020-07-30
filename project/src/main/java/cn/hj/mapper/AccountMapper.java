package cn.hj.mapper;

import cn.hj.domain.Account;

import java.util.List;


public interface AccountMapper {
    public List<Account> findAll();

    public List<Account> findAllLazy();

    //查询某个用户下所有的账号
    public List<Account> findByUid(int uid);


}

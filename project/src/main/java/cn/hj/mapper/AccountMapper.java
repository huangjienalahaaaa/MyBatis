package cn.hj.mapper;


import cn.hj.domain.Account;

import java.util.List;

public interface AccountMapper {

    //查询所有的账号信息，内连接的查询
    public List<Account> findAll();
}

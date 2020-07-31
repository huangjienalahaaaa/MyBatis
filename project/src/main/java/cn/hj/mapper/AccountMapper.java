package cn.hj.mapper;

import cn.hj.domain.Account;

import java.util.List;


public interface AccountMapper {
    public List<Account> findAll();

    public List<Account> findAllLazy();

    public List<Account> findByUid(int uid);


}

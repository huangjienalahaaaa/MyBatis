package cn.hj.mapper;

import cn.hj.domain.Account;

import java.util.List;


public interface AccountMapper {
    // 立即加载
    public List<Account> findAll();

    // 延迟加载
    public List<Account> findAllLazy();

}

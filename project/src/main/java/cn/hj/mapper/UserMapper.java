package cn.hj.mapper;

import cn.hj.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findById();

    //延迟加载
    public List<User> findAllLazy();
}

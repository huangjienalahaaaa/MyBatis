package cn.hj.mapper;

import cn.hj.domain.User;

import java.util.List;

public interface UserMapper {
    //一对多查询
    public List<User> findAll();
}

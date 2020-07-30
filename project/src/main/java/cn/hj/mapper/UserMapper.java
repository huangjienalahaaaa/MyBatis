package cn.hj.mapper;

import cn.hj.domain.User;

import java.util.List;

public interface UserMapper {
    //if拼接查询
    public List<User> findByWhere(User user);
}

package cn.hj.mapper;

import cn.hj.domain.User;

import java.util.List;

public interface UserMapper {
    //foreach标签
    public List<User> findByIds(User user);
}

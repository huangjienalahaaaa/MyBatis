package cn.hj.mapper;

import cn.hj.domain.User;

import java.util.List;

public interface UserMapper {
    //通过id查询
    public List<User> findById();
}

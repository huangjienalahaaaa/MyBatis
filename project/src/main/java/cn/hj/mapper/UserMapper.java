package cn.hj.mapper;

import cn.hj.domain.QueryVo;
import cn.hj.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();

    public User findById(Integer userId);

    public void insert(User user);

    public void update(User user);

    public void delete(Integer userId);

    public List<User> findByName(String username);

    public Integer findByCount();

    public List<User> findByVo(QueryVo vo);

    //演示resultMap配置
    public List<User> findUsers();

}

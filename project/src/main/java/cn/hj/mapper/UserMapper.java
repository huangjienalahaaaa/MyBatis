package cn.hj.mapper;

import cn.hj.domain.User;

import java.util.List;

/**
 * 编写UserMapper的接口和方法（就是咱们以前的UserDao接口）
 *
 *  这里的UserMapper是一个接口，我们的框架会自动生成一个代理类，这个代理类去实现相关配置文件中的sql语句（这里是cn.tx.mapper.UserMapper中的select * from user;语句）
 */
public interface UserMapper {
    /**
     * 查询所有的用户
     * @return
     */
    public List<User> findAll();
}

package cn.hj.mapper;

import cn.hj.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    public List<User> findById();

    public List<User> findAllLazy();


    @Select("select * from user")
    @Results(id="userMap",value= {
            @Result(id=true,column="id",property="id"),
            @Result(column="username",property="username"),
            @Result(column="birthday",property="birthday"),
            @Result(column="sex",property="sex"),
            @Result(column="address",property="address")
    })
    public List<User> findAll();


    @Select(value="select * from user where id = #{uid}")
    @ResultMap(value="userMap")
    public User findById(Integer uid);

    @Insert(value="insert into user (username,birthday,sex,address) values (#{username},#{birthday},#{sex},#{address})")
    public void insert(User user);

    @Update("update user set username = #{username},birthday=#{birthday},sex=#{sex},address=#{address} where id = #{id}")
    public void update(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(Integer userId);

    @Select("select count(*) from user")
    public Integer findByCount();

    @Select("select * from user where username like #{username}")
    public List<User> findByUsername(String username);

}

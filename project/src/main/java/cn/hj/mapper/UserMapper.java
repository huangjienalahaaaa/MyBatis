package cn.hj.mapper;

import cn.hj.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    public List<User> findById();

    public List<User> findAllLazy();


    @Select("select * from user")
    /**
     * @Results注解(作用：封装数据)：
     *      1. id:给这个注解起名字
     *      2. @Result():每一个属性要用一个  @Result()
     */
    @Results(id="userMap",value= {
//            @Result(column="id",property="id"),
            @Result(id=true,column="id",property="id"),
            @Result(column="username",property="username"),
            @Result(column="birthday",property="birthday"),
            @Result(column="sex",property="sex"),
            @Result(column="address",property="address")
    })
    public List<User> findAll();


    @Select(value="select * from user where id = #{uid}")
    /**
     * @ResultMap注解：
     *         用来引入已经写好的数据封装，这里也就是上面写好的@Results()
     */
    @ResultMap(value="userMap")
    public User findById(Integer uid);

    // 保存
    @Insert(value="insert into user (username,birthday,sex,address) values (#{username},#{birthday},#{sex},#{address})")
    public void insert(User user);

    // 修改
    @Update("update user set username = #{username},birthday=#{birthday},sex=#{sex},address=#{address} where id = #{id}")
    public void update(User user);

    // 删除
    @Delete("delete from user where id = #{id}")
    public void delete(Integer userId);

    // 查询数量
    @Select("select count(*) from user")
    public Integer findByCount();

    // 模糊查询
    @Select("select * from user where username like #{username}")
    public List<User> findByUsername(String username);

}

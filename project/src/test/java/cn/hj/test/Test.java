package cn.hj.test.java.cn.hj.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import cn.hj.mapper.AccountMapper;
import cn.hj.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UserTest {

    private InputStream in;
    private SqlSession session;
    private UserMapper mapper;

    // 初始化的方法
    @Before
    public void init() throws Exception {
        // 加载主配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建工厂对象
        factory = new SqlSessionFactoryBuilder().build(in);
        // 创建session
        session = factory.openSession();
        // 获取到代理对象
        mapper = session.getMapper(UserMapper.class);
    }

    // 销毁的方法
    @After
    public void destory() throws Exception {
        // 关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        // 调用方法
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindById() {
        User user = mapper.findById(41);
        System.out.println(user);
    }

    /**
     * 保存
     * @throws Exception
     */
    @Test
    public void testInsert() throws Exception {
        // 创建User对象
        User user = new User();
        user.setUsername("美美2");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("监狱");

        // 保存
        mapper.insert(user);
        session.commit();
    }

    /**
     * 测试
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {
        // 先通过id查询
        User user = mapper.findById(41);
        // 设置新的数据内容
        user.setUsername("熊大");
        user.setAddress("深林深处");

        // 修改
        mapper.update(user);
        session.commit();
    }

    /**
     * 删除
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {
        mapper.delete(42);
        session.commit();
    }

    /**
     * 查询的是聚合函数
     * @throws Exception
     */
    @Test
    public void testFindByCount() throws Exception {
        Integer count = mapper.findByCount();
        System.out.println("总数量："+count);
    }

    /**
     * 模糊查询
     * @throws Exception
     */
    @Test
    public void testFindByUsername() throws Exception {
        // 第一种测试的方式
        List<User> list = mapper.findByUsername("%王%");
        for (User user : list) {
            System.out.println(user);
        }
    }

}
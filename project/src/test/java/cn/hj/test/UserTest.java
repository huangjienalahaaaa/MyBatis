package cn.hj.test.java.cn.hj.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        mapper = session.getMapper(UserMapper.class);
    }

    @After
    public void destory() throws IOException {
        in.close();
        session.close();
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        in.close();
    }

    @Test
    public void testFindById() throws Exception {
        User user = mapper.findById(41);
        System.out.println(user);
        in.close();
    }

    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setUsername("美美");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("顺义");
        mapper.insert(user);
        session.commit();
        System.out.println(user.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        User user = mapper.findById(41);
        user.setUsername("小凤");
        mapper.update(user);
        session.commit();
    }

    @Test
    public void testDelete() throws Exception {
        mapper.delete(48);
        session.commit();
    }

    @Test
    public void testFindByName() throws Exception {
        List<User> list = mapper.findByName("%王%");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByName() throws Exception {
        List<User> list = mapper.findByName("王");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByCount() throws Exception {
        Integer count = mapper.findByCount();
        System.out.println("总记录数："+count);
    }

}
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

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        mapper = session.getMapper(UserMapper.class);
    }

    @After
    public void destory() throws Exception {
        session.close();
        in.close();
    }

    /**
     * 测试 - 多对一的延迟加载
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        // 调用方法
        List<Account> list = mapper.findAll();
        for (Account account : list) {
            //验证延迟加载的话，要使用get****()的方式，
            System.out.println(account.getMoney());
            System.out.println(account.getUser());
        }
    }

}
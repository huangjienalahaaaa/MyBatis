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
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        mapper = session.getMapper(UserMapper.class);
    }

    @After
    public void destory() throws IOException {
        in.close();
        session.close();
    }


//    测试 延迟加载
    @Test
    public void testFindByForeach() throws Exception {
        List<User> list= mapper.findAllLazy();
        for (User user : list) {
            System.out.println(user.getUsername());
            //再打印账号
            System.out.println(user.getAccounts().size());
        }
    }
}
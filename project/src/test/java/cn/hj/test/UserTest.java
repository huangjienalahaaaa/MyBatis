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

    /**
     * 测试if拼接查询
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {
        User user = new User();
        user.setUsername("%王%");
        user.setSex("女");

        // 条件查询
        List<User> list = dao.findByWhere(user);
        for (User user2 : list) {
            System.out.println(user2);
        }

    }
}
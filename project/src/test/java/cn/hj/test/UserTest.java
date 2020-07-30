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
    public void testFindByForeach() throws Exception {
        User user = new User();
        List<Integer> ids = new ArrayList<>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        user.setIds(ids);

        List<User> list = mapper.findByIds(user);
        for (User user2 : list) {
            System.out.println(user2);
        }
    }
}
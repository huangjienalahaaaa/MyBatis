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


//    测试 证明一级缓存的存在
    @Test
    public void testFindByForeach() throws Exception {
        //先查询一级缓存，没有数据。会查询数据库，就会有SQL语句，然后把查询出来的数据存储到一级缓存中。
        User user= mapper.findById(1);
        //打印地址
        System.out.println(user);


        //在查询一次
        //先查询一级缓存，存在数据的话，就从缓存中把数据返回，没有SQL语句。
        User user1= mapper.findById(1);
        //打印地址，可以看到地址是一样的跟上面的。
        System.out.println(user1);




        for (User user : list) {
            System.out.println(user.getUsername());
            //再打印账号
            System.out.println(user.getAccounts().size());
        }
    }
}
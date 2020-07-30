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

        //创建Session对象，

        // 第一种：没有设置事务的方式，默认手动提交。如果使用手动提交，如下面测试类中，每次事务要 session.commit()手动提交一下。
        session = factory.openSession();

        /* 第二种：开启自动提交事务
        *    * 在 session = factory.openSession();的()中使用ctrl +p ，可以查看参数的情况
        */
        session = factory.openSession(true);


        mapper = session.getMapper(UserMapper.class);
    }

    @After
    public void destory() throws IOException {
        in.close();
        session.close();
    }

    /**
     * 测试事务
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {
        //删除方法。开启自动提交后，执行完成一个操作，默认立马提交这个操作的事务
       mapper.delete(1);

        //手动提交代码
        //session.commit();
    }
}
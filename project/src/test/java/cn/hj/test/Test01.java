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


public class Test01 {

    @Test
    public void testFindByForeach() throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user= mapper.findById(1);
        System.out.println(user);
        session.close();


        SqlSession session1 = factory.openSession();
        UserMapper mapper1 = session1.getMapper(UserMapper.class);

        User user1= mapper1.findById(1);
        System.out.println(user1);
        session1.close();

        inputStream.close();

    }
}
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

    //    测试 证明二级缓存的存在
    @Test
    public void testFindByForeach() throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一个一级缓存session
        SqlSession session = factory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user= mapper.findById(1);
        System.out.println(user);
        //删除第一个一级缓存
        session.close();



        //第二个一级缓存session
        SqlSession session1 = factory.openSession();
        UserMapper mapper1 = session1.getMapper(UserMapper.class);

        User user1= mapper1.findById(1);
        System.out.println(user1);
        //删除第二个一级缓存
        session1.close();

        /**
         * 运行这个测试代码后，可以发现 myBatis向数据库请求了2次SQL语句，也就是一级缓存的不足。
         */

        inputStream.close();

    }
}
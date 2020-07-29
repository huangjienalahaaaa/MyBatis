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


/**
 * @Test单元测试，有2个方法，  @Before和  @After。这两个方法分别是在@Test单元测试这个方法之前和之后执行。
 *
 */

public class UserTest {

    private InputStream in;
    private SqlSession session;
    private UserMapper mapper;

    @Before
    public void init() throws Exception {
        // 加载配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建Session对象
        session = factory.openSession();
        // 获取到代理对象
        mapper = session.getMapper(UserMapper.class);
    }

    @After
    public void destory() throws IOException {
        in.close();
        session.close();
    }

    /**
     * 测试查询所有的方法
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        List<User> list = mapper.findAll();
        // 遍历
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

        //手动提交事务，如果不提交事务的话。可以看到：本地代码是执行成功了，但是数据却没有增加到数据库中
        session.commit();


        /*
        因为User对象的id值是数据库自增的，咋们并没有对其赋值。所以此时我们数据库是有这个id值的，但是下面我们user.getId()是获取不到这个id值的。
            -> 所以要再配置文件(UserMapper.xml)中进行设置：


            <selectKey keyProperty="id" order="AFTER" resultType="java.lang.Integer">
			    select last_insert_id();
		    </selectKey>

        */
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

    // 第一种
    @Test
    public void testFindByName() throws Exception {
        // 1. %王表示：所有以王结尾的  2. 王%表示：所有以王开头的
        List<User> list = mapper.findByName("%王%");
        for (User user : list) {
            System.out.println(user);
        }
    }
    // 第二种
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
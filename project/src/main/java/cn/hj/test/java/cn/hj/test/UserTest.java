package cn.hj.test.java.cn.hj.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.hj.domain.User;
import cn.hj.mapper.UserMapper;


/**
 * 编写入门程序（重点掌握入门的步骤）
 */
public class UserTest {

    /**
     * 测试查询所有的方法
     * @throws Exception
     *
     * 1. 问题解决：
     *  1. 尽管导入junit包（import org.junit.Test;) @Test还是报错:
     *      * 问题分析：
     *          发现去掉dependency中的<scope>test</scope>就好了，于是查看<scope>的作用：
     *          scope为test指的是测试范围有效，在编译和打包时都不会使用这个依赖，意思就是src/main/java/里面的类都不可使用scope为test的依赖包，这就解释了第一步我遇到的问题。
     *       * 问题解决：
     *          在src下新建文件夹src/test/java/，设置该文件夹为Test Source Root（测试代码根目录），就可以在该文件夹下的类中使用scope为test的依赖包了
     *
     */
    @Test
    public void testFindAll() throws Exception {
        // 加载主配置文件，目的是构建SqlSessionFactory的对象
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 使用SqlSessionFactory工厂对象创建SqlSession对象
        SqlSession session = factory.openSession();
        // 通过session创建UserMapper接口的代理对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        // 调用查询所有的方法
        List<User> list = mapper.findAll();
        // 遍历集合
        for (User user : list) {
            System.out.println(user);
        }
        // 释放资源
        session.close();
        in.close();
    }

    @Test
    public void run2() throws Exception {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 构建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取到session对象
        SqlSession session = factory.openSession();
        // 查询所有的数据
        List<User> list = session.selectList("cn.hj.mapper.UserMapper.findAll");
        // 变量集合
        for (User user : list) {
            System.out.println(user);
        }
        // 关闭资源
        session.close();
        inputStream.close();
    }
}
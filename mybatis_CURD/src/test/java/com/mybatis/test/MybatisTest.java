package com.mybatis.test;

import com.mybatis.dao.IUserDao;
import com.mybatis.domain.QueryVo;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Test
    public void getAll() {
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void update(){
        User user = new User();
        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setId(45);
        user.setUsername("果冻");
        userDao.updateUser(user);

    }
    @Test
    public void delete(){
     userDao.delete(45);

    }

    @Test
    public void save() {
        User user = new User();
        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setUsername("果果");
        userDao.saveUser(user);
    }

    @Test
    public void findId(){
        User userId = userDao.findUserId(45);
        System.out.println(userId);
    }

    @Test
    public void findTotal(){
        System.out.println(userDao.findTotal());
    }
    @Test
    public void findVo(){

        QueryVo queryVo = new QueryVo();
        User user1 = new User();
        user1.setUsername("%果%");
        queryVo.setUser(user1);
        List<User> vo = userDao.findVo(queryVo);
        for (User user : vo) {
            System.out.println(user);
        }

    }

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产sqlSession对象
        session = factory.openSession();
        //4.使用sqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destoty() throws IOException {
        session.commit();
        session.close();
        in.close();

    }
}

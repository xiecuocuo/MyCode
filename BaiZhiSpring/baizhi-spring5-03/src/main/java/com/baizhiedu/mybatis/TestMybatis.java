package com.baizhiedu.mybatis;

import com.baizhiedu.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {
    @Test
    public void test1(){
        InputStream inputStream= null;
        SqlSession sqlSession=null;
        try {
            //构建SqlSessionFactory
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
            //获取SqlSession
            sqlSession=sqlSessionFactory.openSession();
            UserDao userDao=sqlSession.getMapper(UserDao.class);
            userDao.addUser(new User("niuweiwei","abc1234"));
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }

    }
}

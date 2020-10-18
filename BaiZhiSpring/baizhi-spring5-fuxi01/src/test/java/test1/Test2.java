package test1;

import com.baizhiedu.bean.User;
import com.baizhiedu.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test2 {
    @Test
    public void test1(){
        //构建SqlSessionFactory
        InputStream inputStream=null;
        SqlSession sqlSession=null;
        try {
             inputStream = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
            //获取SqlSession
            sqlSession=sqlSessionFactory.openSession();
            UserDao userDao=sqlSession.getMapper(UserDao.class);
            userDao.addUser(new User("liujiahao","abc1234"));
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
                if(sqlSession !=null){
                    sqlSession.close();
                }
            }catch (Exception e){

            }

        }

    }
}

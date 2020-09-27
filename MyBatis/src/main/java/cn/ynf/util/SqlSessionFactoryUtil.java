package cn.ynf.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory=null;
    //类线程锁
    private static Class CLASS_LOCK=SqlSessionFactoryUtil.class;
    private SqlSession sqlSession=null;

    private static SqlSessionFactory initSqlSessionFactory(){
        String configPath="mybatisConfig1.xml";
        InputStream is=null;
        try {
            is= Resources.getResourceAsStream(configPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        synchronized (CLASS_LOCK){
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(is);
        }
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession(){
        if(sqlSessionFactory==null){
            sqlSessionFactory=initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}

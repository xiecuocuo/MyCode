package cn.ynf.test;

import cn.ynf.bean.Employee;
import cn.ynf.mapper.EmployeeMapper;
import cn.ynf.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test1 {
    @Test
    public void test1(){
        SqlSession sqlSession= SqlSessionFactoryUtil.getSqlSession();
        EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
        Employee employee=employeeMapper.getByEmpNo(7895);
        System.out.println(employee);
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession= SqlSessionFactoryUtil.getSqlSession();
        Employee employee=sqlSession.selectOne("getByEmpNo",7895);
        System.out.println(employee);
        sqlSession.close();
    }
}

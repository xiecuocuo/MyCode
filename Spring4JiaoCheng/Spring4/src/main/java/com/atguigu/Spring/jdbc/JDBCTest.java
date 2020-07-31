package com.atguigu.Spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

public class JDBCTest {
    private ApplicationContext ctx=null;
    private JdbcTemplate jdbcTemplate=null;
    private EmpDao empDao;
    private DepartmentDao deptDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JDBCTest(){
        ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate= (JdbcTemplate) ctx.getBean("JdbcTemplate");
        empDao= (EmpDao) ctx.getBean("empDao");
        deptDao= (DepartmentDao) ctx.getBean("departmentDao");
        namedParameterJdbcTemplate= (NamedParameterJdbcTemplate) ctx.getBean("NamedParameterJdbcTemplate");
    }


    @Test
    public void test() throws SQLException {
        DataSource ds= (DataSource) ctx.getBean("dataSource");
        System.out.println(ds.getConnection());
    }
    //执行insert,update,delete
    @Test
    public void testUpdate(){
        jdbcTemplate.update("update dept set dname=? where deptno=?","RESEARCH1",20);
    }
    //执行批量更新：批量的INSERT,update,delete
    //最后一个参数是Object[]的List类型，因为修改一条记录需一个Object[],那么修改多条就需要Object[]组成的List
    @Test
    public void testBatchUpdate(){
        String sql="INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values (?,?,?,?,?,?,?,?)";
        List<Object[]> batchArgs=new ArrayList<>();
        batchArgs.add(new Object[]{"7934","liMing1",null,null,null,null,null,null});
        batchArgs.add(new Object[]{"7935","liMing2",null,null,null,null,null,null});
        batchArgs.add(new Object[]{"7936","liMing3",null,null,null,null,null,null});
        batchArgs.add(new Object[]{"7937","liMing4",null,null,null,null,null,null});
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    /*
    * 从数据库中取出一条记录，实际得到对应的一个对象
    * 注意不是调用queryForObject(String sql,Class<Emp> requiedType,Object ... args)方法
    * 而需要调用queryForObject(String sql,RowMapper<Emp) rowMapper,Object... args)方法
    * 1.其中RowMapper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
    * 2.使用SQL中列的别名完成列名和类的属性名映射,例如last_name--->lastName
    * 3.不支持级联属性，jdbcTemplate到底是一个jdbc的小工具，而不是orm框架
    * */
    @Test
    public void testQueryForObject(){
        String sql="select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp where empno= ?";
        RowMapper<Emp> rowMapper=new BeanPropertyRowMapper<>(Emp.class);
        Emp emp=jdbcTemplate.queryForObject(sql,rowMapper,7788);
        System.out.println(emp);
    }

    /*
    查到实体类的集合
    * */
    @Test
    public void testQueryForList(){
        String sql="select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp where empno > ?";
        RowMapper<Emp> rowMapper=new BeanPropertyRowMapper<Emp>(Emp.class);
        List<Emp> emps=jdbcTemplate.query(sql,rowMapper,10);
        System.out.println(emps);
    }
    /*
    获取单个实例
    * */
    @Test
    public void queryForObject(){
        String sql="select count(1) from emp";
        Integer num=jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(num);
    }

    @Test
    public void testEmpDao(){
        List<Emp> emps=empDao.getEmps();
        System.out.println(emps);
    }

    @Test
    public void testDepartmentDao(){
        List<Dept> depts=deptDao.getDepts();
        System.out.println(depts);
    }
    /*
    * 可以给参数起名字：
    * 1.好处：如果有多个参数，不用再去对应位置，直接对应参数名，便于维护
    * 2.缺点：较为麻烦
    * */
    @Test
    public void testNamedParameterJdbcTemplate(){
        String sql="INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values (:empno,:ename,:job,:mgr,:hiredate,:sal,:comm,:deptno)";
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("empno","7937");
        map.put("ename","LiMing4");
        namedParameterJdbcTemplate.update(sql,map);
    }
    /*
    使用具名参数时可以使用 public int update(String sql, SqlParameterSource paramSource) 方法进行更新操作
    1.sql语句中的参数名和类的属性一致
    2.使用SqlParameterSource的BeanPropertySqlParameterSource实现类作为参数
    * */
    @Test
    public void testNamedParameterJdbcTemplate2(){
        String sql="INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values (:empno,:ename,:job,:mgr,:hiredate,:sal,:comm,:deptno)";
        Emp emp=new Emp();
        emp.setEmpno(7937);
        emp.setEname("LiMing5");
        SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(emp);
        namedParameterJdbcTemplate.update(sql,parameterSource);
    }
}

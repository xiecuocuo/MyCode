package com.atguigu.Spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Emp> getEmps(){
        String sql="select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp";
        RowMapper<Emp> rowMapper=new BeanPropertyRowMapper<Emp>(Emp.class);
        List<Emp> emps=jdbcTemplate.query(sql,rowMapper);
        return emps;
    }
}

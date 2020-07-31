package com.atguigu.Spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import java.util.*;
import javax.sql.DataSource;

//给它注入一个DataSource或者JdbcTemplate
@Repository
public class DepartmentDao extends JdbcDaoSupport {
    @Autowired
    public void setDataSource2(DataSource dataSource){
        setDataSource(dataSource);
    }

    public List<Dept> getDepts(){
        String sql="select deptno,dname,loc from dept";
        RowMapper<Dept> rowMapper=new BeanPropertyRowMapper<Dept>(Dept.class);
        List<Dept> depts=getJdbcTemplate().query(sql,rowMapper);
        return depts;
    }
}

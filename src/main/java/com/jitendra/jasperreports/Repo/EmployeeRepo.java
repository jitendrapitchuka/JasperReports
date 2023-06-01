package com.jitendra.jasperreports.Repo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.jitendra.jasperreports.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getAll(){
        String query="select * from employee";
        List<Employee> employees=jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Employee.class));
        System.out.println(employees.toString());
        return  employees;
    }


}

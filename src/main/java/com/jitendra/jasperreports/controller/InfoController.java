package com.jitendra.jasperreports.controller;

import com.jitendra.jasperreports.entity.Employee;
import com.jitendra.jasperreports.service.EmployeeService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class InfoController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmp")
    public ResponseEntity<List<Employee>>  getAllEmp(){
        List<Employee> employees=employeeService.getAll();

        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return employeeService.exportReport(format);
    }
}

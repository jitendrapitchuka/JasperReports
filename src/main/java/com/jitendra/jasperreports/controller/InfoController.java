package com.jitendra.jasperreports.controller;

import com.jitendra.jasperreports.entity.Employee;
import com.jitendra.jasperreports.service.EmailSenderService;
import com.jitendra.jasperreports.service.EmployeeService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class InfoController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmailSenderService emailSenderService;
    @GetMapping("/getEmp")
    public ResponseEntity<List<Employee>>  getAllEmp(){
        List<Employee> employees=employeeService.getAll();

        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return employeeService.exportReport(format);
    }

    @PostMapping("/send")
    @EventListener(ApplicationReadyEvent.class)
    public String sendEmail(){
        emailSenderService.sendSimpleEmail("jithendra2900@gmail.com"
                ,"this is test email","Test");
        return "email send";
    }

    @PostMapping("/sendAttachment")
    @EventListener(ApplicationReadyEvent.class)
    public String sendEmailAttach() throws MessagingException {
        emailSenderService.sendEmailAttachment("jithendra2900@gmail.com"
                ,"I want to leave my job :(","From chinna","src/main/resources/employees.pdf");
        return "email attachment sent";
    }




}

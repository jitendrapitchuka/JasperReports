package com.jitendra.jasperreports.entity;



import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Employee {

    @Id
    private int id;
    private String name;
    private String designation;
    private double salary;
    private String doj;

}

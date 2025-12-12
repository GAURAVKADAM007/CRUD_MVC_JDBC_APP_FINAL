package com.stackninjas.crudapp.model;

public class Employee {
    private int id ;
    private String name;
    private String salary;
    private String Department;

    public Employee() {}

    public Employee(String name, String salary, String department) {
        this.name = name;
        this.salary = salary;
        Department = department;
    }

    public Employee(int id, String name, String salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        Department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}

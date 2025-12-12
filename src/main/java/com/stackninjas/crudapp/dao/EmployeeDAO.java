package com.stackninjas.crudapp.dao;

import com.stackninjas.crudapp.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void insert(Employee employee);
    void delete(int id );
    void update(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
}

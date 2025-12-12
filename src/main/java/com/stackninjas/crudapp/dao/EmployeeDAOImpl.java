package com.stackninjas.crudapp.dao;

import com.stackninjas.crudapp.exception.EmployeeDAOException;
import com.stackninjas.crudapp.model.Employee;
import com.stackninjas.crudapp.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    private static final String INSERT_SQL ="INSERT INTO employee(name,salary,department) VALUES(?,?,?)";
    private static final String DELETE_SQL ="DELETE FROM employee WHERE eid=?;";
    private static final String UPDATE_SQL ="UPDATE employee SET name=? ,salary=?,department=? WHERE id=?";
    private static final String GET_BY_ID_SQL ="SELECT * FROM employee WHERE eid=?";
    private static final String GET_ALL_SQL ="SELECT * FROM employee ORDER BY eid";

    @Override
    public void insert(Employee employee) {
        try(Connection connection = JDBCUtils.fetchConnection();
            PreparedStatement stmt = connection.prepareStatement(INSERT_SQL)){
            stmt.setString(1,employee.getName());
            stmt.setString(2,employee.getSalary());
            stmt.setString(3,employee.getDepartment());
            stmt.executeUpdate();
        }catch (SQLException sqle){
            throw new EmployeeDAOException("Unable to Insert Record",sqle);
        }
    }

    @Override
    public void delete(int id) {
        try(Connection connection = JDBCUtils.fetchConnection();
            PreparedStatement stmt = connection.prepareStatement(DELETE_SQL)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch (SQLException sqle){
            throw new EmployeeDAOException("Unable to Delete Record",sqle);
        }
    }

    @Override
    public void update(Employee employee) {
        try(Connection connection = JDBCUtils.fetchConnection();
            PreparedStatement stmt = connection.prepareStatement(UPDATE_SQL)){
            stmt.setString(1,employee.getName());
            stmt.setString(2,employee.getSalary());
            stmt.setString(3,employee.getDepartment());
            stmt.setInt(1,employee.getId());

            stmt.executeUpdate();
        }catch (SQLException sqle){
            throw new EmployeeDAOException("Unable to Update Record",sqle);
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try(Connection connection = JDBCUtils.fetchConnection();
            PreparedStatement stmt = connection.prepareStatement(GET_BY_ID_SQL)){
            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    new Employee(
                            rs.getString("name"),
                            rs.getString("salary"),
                            rs.getString("Department")
                            );
                }
            }
        }catch (SQLException sqle){
            throw new EmployeeDAOException("Unable to Fetch Record",sqle);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        try(Connection connection = JDBCUtils.fetchConnection();
            PreparedStatement stmt = connection.prepareStatement(GET_ALL_SQL);
            ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                Employee employee = new Employee(
                        rs.getInt("name"),
                        rs.getString("name"),
                        rs.getString("salary"),
                        rs.getString("Department")
                );
                employeeList.add(employee);
            }
        }catch (SQLException sqle){
            throw new EmployeeDAOException("Unable to Fetch Record",sqle);
        }
        return employeeList;
    }
}

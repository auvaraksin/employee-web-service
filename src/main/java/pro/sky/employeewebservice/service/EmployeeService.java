package pro.sky.employeewebservice.service;

import pro.sky.employeewebservice.data.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> getEmployeeList();
}

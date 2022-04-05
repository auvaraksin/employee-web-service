package pro.sky.employeewebservice.service;

import pro.sky.employeewebservice.data.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName);
    Employee removeEmployee(String lastName, String firstName);
    Employee findEmployee(String lastName, String firstName);
    List<Employee> getEmployeeList();
}

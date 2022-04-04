package pro.sky.employeewebservice.service;

import pro.sky.employeewebservice.data.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String lastName);
    Employee findEmployee(String lastName);
    List<Employee> getEmployeeList();
}

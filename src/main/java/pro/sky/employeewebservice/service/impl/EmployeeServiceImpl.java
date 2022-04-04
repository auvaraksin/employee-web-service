package pro.sky.employeewebservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employeewebservice.data.Employee;
import pro.sky.employeewebservice.exceptions.ArrayIsFullException;
import pro.sky.employeewebservice.exceptions.EmployeeExistsException;
import pro.sky.employeewebservice.exceptions.EmployeeNotFoundException;
import pro.sky.employeewebservice.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.containsKey(lastName)) {
            throw new EmployeeExistsException();
        }
        employees.put(lastName, new Employee(firstName, lastName));
        return employees.get(lastName);
    }

    @Override
    public Employee removeEmployee(String lastName) {
        if (!employees.containsKey(lastName)) {
            throw new EmployeeNotFoundException();
        }
        Employee employee = employees.get(lastName);
        employees.remove(lastName);
        return employee;
    }

    @Override
    public Employee findEmployee(String lastName) {
        if (!employees.containsKey(lastName)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(lastName);
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>(employees.values());
        return employeeList;
    }

}

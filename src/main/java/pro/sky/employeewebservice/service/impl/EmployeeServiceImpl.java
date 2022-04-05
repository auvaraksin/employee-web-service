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
    public Employee addEmployee(String lastName, String firstName) {
        String s = lastName + ' ' + firstName;
        if (employees.containsKey(s)) {
            throw new EmployeeExistsException();
        }
        employees.put(s, new Employee(lastName, firstName));
        return employees.get(s);
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        String s = lastName + ' ' + firstName;
        if (!employees.containsKey(s)) {
            throw new EmployeeNotFoundException();
        }
        Employee employee = employees.get(s);
        employees.remove(s);
        return employee;
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        String s = lastName + ' ' + firstName;
        if (!employees.containsKey(s)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(s);
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>(employees.values());
        return employeeList;
    }

}

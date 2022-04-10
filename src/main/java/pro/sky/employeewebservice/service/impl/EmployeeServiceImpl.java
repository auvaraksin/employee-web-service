package pro.sky.employeewebservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employeewebservice.data.Employee;
import pro.sky.employeewebservice.exceptions.EmployeeExistsException;
import pro.sky.employeewebservice.exceptions.EmployeeNotFoundException;
import pro.sky.employeewebservice.service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String lastName, String firstName, Integer idDepartment, Integer salaryPerMonth) {
        String s = lastName + ' ' + firstName;
        if (employees.containsKey(s)) {
            throw new EmployeeExistsException();
        }
        employees.put(s, new Employee(lastName, firstName, idDepartment, salaryPerMonth));
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

    @Override
    public String calculateTotalSumMonthSalary() {
        return "Общая сумма затрат на зарплату в месяц: "
                + String.valueOf(employees.values().stream()
                .mapToInt(e -> e.getSalaryPerMonth())
                .sum())
                + " руб.";
    }

    @Override
    public List<Employee> findEmployeeWithMaxSalaryInDepartment(Integer idDepartment) {
        Integer maxSalary = employees.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .map(e -> e.getSalaryPerMonth())
                .max(Integer::compare).get();
        List<Employee> listOfEmployeesWithMaxSalary = employees.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .filter(e -> e.getSalaryPerMonth().equals(maxSalary)).collect(Collectors.toList());
        return listOfEmployeesWithMaxSalary;
    }

    @Override
    public List<Employee> findEmployeeWithMinSalaryInDepartment(Integer idDepartment) {
        Integer minSalary = employees.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .map(e -> e.getSalaryPerMonth())
                .min(Integer::compare).get();
        List<Employee> listOfEmployeesWithMinSalary = employees.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .filter(e -> e.getSalaryPerMonth().equals(minSalary)).collect(Collectors.toList());
        return listOfEmployeesWithMinSalary;
    }

    @Override
    public List<Employee> findAllEmployeesByIdDepartment(Integer idDepartment) {
        return employees.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortListOfEmployeesByDepartment() {
        return employees.values().stream()
                .sorted(Comparator.comparing(Employee::getIdDepartment)).collect(Collectors.toList());
    }

}

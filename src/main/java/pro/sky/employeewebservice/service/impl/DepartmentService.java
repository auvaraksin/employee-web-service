package pro.sky.employeewebservice.service.impl;

import pro.sky.employeewebservice.data.Employee;

import java.util.List;

public interface DepartmentService {
    Employee addEmployee(String lastName, String firstName, Integer idDepartment, Integer salaryPerMonth);

    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    List<Employee> getEmployeeList();

    String calculateTotalSumMonthSalary();

    List<Employee> findEmployeeWithMaxSalaryInDepartment(Integer idDepartment);

    List<Employee> findAllEmployeesByIdDepartment(Integer idDepartment);

    List<Employee> findEmployeeWithMinSalaryInDepartment(Integer idDepartment);

    List<Employee> sortListOfEmployeesByDepartment();
}

package pro.sky.employeewebservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employeewebservice.data.Employee;
import pro.sky.employeewebservice.data.EmployeeRepository;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(String lastName, String firstName, Integer idDepartment, Integer salaryPerMonth) {
        return employeeRepository.addEmployee(lastName, firstName, idDepartment, salaryPerMonth);
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        return employeeRepository.removeEmployee(lastName, firstName);
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        return employeeRepository.findEmployee(lastName, firstName);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.getEmployeeList();
    }

    @Override
    public String calculateTotalSumMonthSalary() {
        return employeeRepository.calculateTotalSumMonthSalary();
    }

    @Override
    public List<Employee> findEmployeeWithMaxSalaryInDepartment(Integer idDepartment) {
        return employeeRepository.findEmployeeWithMaxSalaryInDepartment(idDepartment);
    }

    @Override
    public List<Employee> findEmployeeWithMinSalaryInDepartment(Integer idDepartment) {
        return employeeRepository.findEmployeeWithMinSalaryInDepartment(idDepartment);
    }

    @Override
    public List<Employee> findAllEmployeesByIdDepartment(Integer idDepartment) {
        return employeeRepository.findAllEmployeesByIdDepartment(idDepartment);
    }

    @Override
    public List<Employee> sortListOfEmployeesByDepartment() {
        return employeeRepository.sortListOfEmployeesByDepartment();
    }
}

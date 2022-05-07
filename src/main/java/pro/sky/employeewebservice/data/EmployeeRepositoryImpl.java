package pro.sky.employeewebservice.data;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import pro.sky.employeewebservice.exceptions.EmployeeExistsException;
import pro.sky.employeewebservice.exceptions.EmployeeNotFoundException;
import pro.sky.employeewebservice.exceptions.EmployeeWrongNameException;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String lastName, String firstName, Integer idDepartment, Integer salaryPerMonth) {
        checkEmployeeWrongNameException(lastName, firstName);
        String s = StringUtils.capitalize(lastName) + ' ' + StringUtils.capitalize(firstName);
        checkEmployeeExistsException(employees, s);
        employees.put(s, new Employee(StringUtils.capitalize(lastName), StringUtils.capitalize(firstName), idDepartment, salaryPerMonth));
        return employees.get(s);
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        checkEmployeeWrongNameException(lastName, firstName);
        String s = StringUtils.capitalize(lastName) + ' ' + StringUtils.capitalize(firstName);
        checkEmployeeNotFoundException(employees, s);
        Employee employee = employees.get(s);
        employees.remove(s);
        return employee;
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        checkEmployeeWrongNameException(lastName, firstName);
        String s = StringUtils.capitalize(lastName) + ' ' + StringUtils.capitalize(firstName);
        checkEmployeeNotFoundException(employees, s);
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
    public List<Employee> findAllEmployeesByIdDepartment(Integer idDepartment) {
        if (idDepartment == null) {
            throw new NullPointerException("При вызове метода не задан номер отдела");
        } else {
            return employees.values().stream()
                    .filter(e -> e.getIdDepartment().equals(idDepartment))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<Employee> sortListOfEmployeesByDepartment() {
        return employees.values().stream()
                .sorted(Comparator.comparing(Employee::getIdDepartment)).collect(Collectors.toList());
    }

    @Override
    public void checkEmployeeWrongNameException(String lastName, String firstName) {
        if ((StringUtils.isAlpha(lastName) != true) || (StringUtils.isAlpha(firstName) != true)) {
            throw new EmployeeWrongNameException();
        }
    }

    @Override
    public void checkEmployeeExistsException(Map<String, Employee> employees, String s) {
        if (employees.containsKey(s)) {
            throw new EmployeeExistsException();
        }
    }

    @Override
    public void checkEmployeeNotFoundException(Map<String, Employee> employees, String s) {
        if (!employees.containsKey(s)) {
            throw new EmployeeNotFoundException();
        }
    }

}

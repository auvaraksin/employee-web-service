package pro.sky.employeewebservice.data;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    Employee addEmployee(String lastName, String firstName, Integer idDepartment, Integer salaryPerMonth);

    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    List<Employee> getEmployeeList();

    String calculateTotalSumMonthSalary();

    List<Employee> findEmployeeWithMaxSalaryInDepartment(Integer idDepartment);

    List<Employee> findAllEmployeesByIdDepartment(Integer idDepartment);

    List<Employee> findEmployeeWithMinSalaryInDepartment(Integer idDepartment);

    List<Employee> sortListOfEmployeesByDepartment();

    void checkEmployeeWrongNameException(String lastName, String firstName);

    void checkEmployeeExistsException(Map<String, Employee> employees, String s);

    void checkEmployeeNotFoundException(Map<String, Employee> employees, String s);
}

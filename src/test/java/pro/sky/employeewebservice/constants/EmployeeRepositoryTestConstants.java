package pro.sky.employeewebservice.constants;

import pro.sky.employeewebservice.data.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRepositoryTestConstants {
    public static final String DEFAULT_WRONG_EMPLOYEE_LASTNAME = "Ivanov123";
    public static final String DEFAULT_WRONG_EMPLOYEE_FIRSTNAME = "Ivan123";
    public static final String DEFAULT_RIGHT_EMPLOYEE_FIRSTNAME = "Ivan";
    public static final String DEFAULT_RIGHT_EMPLOYEE_LASTNAME = "Ivanov";
    public static final Integer DEFAULT_EMPLOYEE_REPOSITORY_IDDEPARTMENT = 1;
    public static final Integer DEFAULT_EMPLOYEE_REPOSITORY_SALARYPERMONTH = 100000;
    public static final String DEFAULT_KEY = DEFAULT_RIGHT_EMPLOYEE_LASTNAME + DEFAULT_RIGHT_EMPLOYEE_FIRSTNAME;
    public static final Map<String, Employee> DEFAUL_EMPLOYEE_MAP = new HashMap<>((Map.of(
            DEFAULT_KEY,
            new Employee(
                    DEFAULT_RIGHT_EMPLOYEE_LASTNAME,
                    DEFAULT_RIGHT_EMPLOYEE_FIRSTNAME,
                    DEFAULT_EMPLOYEE_REPOSITORY_IDDEPARTMENT,
                    DEFAULT_EMPLOYEE_REPOSITORY_SALARYPERMONTH))));
}

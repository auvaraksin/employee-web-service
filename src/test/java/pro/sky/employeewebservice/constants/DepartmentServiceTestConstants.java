package pro.sky.employeewebservice.constants;

import pro.sky.employeewebservice.data.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentServiceTestConstants {
    public static final String DEFAULT_EMPLOYEE_FIRSTNAME = "Ivan";
    public static final String DEFAULT_EMPLOYEE_LASTNAME = "Ivanov";
    public static final Integer DEFAULT_EMPLOYEE_IDDEPARTMENT = 1;
    public static final Integer DEFAULT_EMPLOYEE_SALARYPERMONTH = 100000;
    public static final Employee DEFAULT_EMPLOYEE =
            new Employee(DEFAULT_EMPLOYEE_LASTNAME,
                    DEFAULT_EMPLOYEE_FIRSTNAME,
                    DEFAULT_EMPLOYEE_IDDEPARTMENT,
                    DEFAULT_EMPLOYEE_SALARYPERMONTH);
    public static final List<Employee> DEFAULT_EMPLOYEE_LIST = new ArrayList<>(Arrays.asList(
                    new Employee("Ivanov", "Ivan", 1, 100000),
                    new Employee("Petrov", "Petr", 1, 150000),
                    new Employee("Fedorov", "Fedor", 1, 125000),
                    new Employee("Ivanova", "Ioanna", 2, 130000),
                    new Employee("Petrova", "Petra", 3, 145000),
                    new Employee("Fedorova", "Feodosiya", 3, 150000)
            ));
    public static final String DEFAULT_TOTAL_MONTH_SALARY_SUMMARY = "800000";
    public static final List<Employee> DEFAULT_LIST_OF_EMPLOYEES_WITH_MIN_MAX_SALARY_IN_DEPT = new ArrayList<>(Arrays.asList(
            new Employee("Ivanov", "Ivan", 1, 100000),
            new Employee("Petrov", "Petr", 1, 100000),
            new Employee("Fedorov", "Fedor", 1, 100000)
    ));

}

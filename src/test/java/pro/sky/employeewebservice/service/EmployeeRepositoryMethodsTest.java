package pro.sky.employeewebservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.employeewebservice.data.EmployeeRepository;
import pro.sky.employeewebservice.data.EmployeeRepositoryImpl;
import pro.sky.employeewebservice.exceptions.EmployeeExistsException;
import pro.sky.employeewebservice.exceptions.EmployeeWrongNameException;

import static pro.sky.employeewebservice.constants.EmployeeRepositoryTestConstants.*;

public class EmployeeRepositoryMethodsTest {
    private final EmployeeRepository mut = new EmployeeRepositoryImpl();

    @Test
    public void shouldThrowEmployeeWrongNameException() {
        Assertions.assertThrows(EmployeeWrongNameException.class, () -> mut.addEmployee(
                DEFAULT_WRONG_EMPLOYEE_LASTNAME,
                DEFAULT_RIGHT_EMPLOYEE_FIRSTNAME,
                DEFAULT_EMPLOYEE_REPOSITORY_IDDEPARTMENT,
                DEFAULT_EMPLOYEE_REPOSITORY_SALARYPERMONTH));
        Assertions.assertThrows(EmployeeWrongNameException.class, () -> mut.addEmployee(
                DEFAULT_WRONG_EMPLOYEE_LASTNAME,
                DEFAULT_RIGHT_EMPLOYEE_FIRSTNAME,
                DEFAULT_EMPLOYEE_REPOSITORY_IDDEPARTMENT,
                DEFAULT_EMPLOYEE_REPOSITORY_SALARYPERMONTH));
    }

    @Test
    public void shouldThrowEmployeeExistsException() {
// прошу пояснить (натолкнуть на мысль) каким образом можно провести тест на исключение класса EmployeeExistsException
//        при вызове метода mut.addEmployee?!
    }


}

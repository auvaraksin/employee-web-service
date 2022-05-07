package pro.sky.employeewebservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.employeewebservice.data.EmployeeRepository;
import pro.sky.employeewebservice.data.EmployeeRepositoryImpl;
import pro.sky.employeewebservice.exceptions.EmployeeExistsException;
import pro.sky.employeewebservice.exceptions.EmployeeNotFoundException;
import pro.sky.employeewebservice.exceptions.EmployeeWrongNameException;

import static pro.sky.employeewebservice.constants.EmployeeRepositoryTestConstants.*;

public class EmployeeRepositoryMethodsTest {
    private final EmployeeRepository mut = new EmployeeRepositoryImpl();

    @Test
    public void shouldThrowEmployeeWrongNameException() {
        Assertions.assertThrows(EmployeeWrongNameException.class,
                () -> mut.checkEmployeeWrongNameException(
                DEFAULT_WRONG_EMPLOYEE_LASTNAME,
                DEFAULT_RIGHT_EMPLOYEE_FIRSTNAME));
        Assertions.assertThrows(EmployeeWrongNameException.class,
                () -> mut.checkEmployeeWrongNameException(
                DEFAULT_RIGHT_EMPLOYEE_LASTNAME,
                DEFAULT_WRONG_EMPLOYEE_FIRSTNAME));
    }

    @Test
    public void shouldThrowEmployeeExistsException() {
        Assertions.assertThrows(EmployeeExistsException.class,
                () -> mut.checkEmployeeExistsException(DEFAULT_EMPLOYEE_MAP, DEFAULT_KEY));
    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> mut.checkEmployeeNotFoundException(DEFAULT_EMPLOYEE_MAP, DEFAULT_WRONG_KEY));
    }

    @Test
    public void shouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> mut.findAllEmployeesByIdDepartment(null));
    }

}

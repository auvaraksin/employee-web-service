package pro.sky.employeewebservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employeewebservice.data.EmployeeRepository;
import pro.sky.employeewebservice.exceptions.EmployeeNotFoundException;
import pro.sky.employeewebservice.exceptions.EmployeeWrongNameException;
import pro.sky.employeewebservice.service.impl.DepartmentServiceImpl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static pro.sky.employeewebservice.constants.DepartmentServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeRepository employeeRepositoryMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldCallRepositoryMethodWhenAddEmployee() {
        when(employeeRepositoryMock.addEmployee(
                DEFAULT_EMPLOYEE_LASTNAME,
                DEFAULT_EMPLOYEE_FIRSTNAME,
                DEFAULT_EMPLOYEE_IDDEPARTMENT,
                DEFAULT_EMPLOYEE_SALARYPERMONTH)).
                thenReturn(DEFAULT_EMPLOYEE);

        Assertions.assertEquals(DEFAULT_EMPLOYEE,
                out.addEmployee(
                        DEFAULT_EMPLOYEE_LASTNAME,
                        DEFAULT_EMPLOYEE_FIRSTNAME,
                        DEFAULT_EMPLOYEE_IDDEPARTMENT,
                        DEFAULT_EMPLOYEE_SALARYPERMONTH));
    }

    @Test
    public void shouldCallRepositoryMethodWhenRemoveEmployee() {
        when(employeeRepositoryMock.removeEmployee(
                DEFAULT_EMPLOYEE_LASTNAME,
                DEFAULT_EMPLOYEE_FIRSTNAME)).
                thenReturn(DEFAULT_EMPLOYEE);

        Assertions.assertEquals(DEFAULT_EMPLOYEE,
                out.removeEmployee(
                        DEFAULT_EMPLOYEE_LASTNAME,
                        DEFAULT_EMPLOYEE_FIRSTNAME));
    }

    @Test
    public void shouldCallRepositoryMethodWhenFindEmployee() {
        when(employeeRepositoryMock.findEmployee(
                DEFAULT_EMPLOYEE_LASTNAME,
                DEFAULT_EMPLOYEE_FIRSTNAME)).
                thenReturn(DEFAULT_EMPLOYEE);

        Assertions.assertEquals(DEFAULT_EMPLOYEE,
                out.findEmployee(
                        DEFAULT_EMPLOYEE_LASTNAME,
                        DEFAULT_EMPLOYEE_FIRSTNAME));
    }

    @Test
    public void shouldCallRepositoryMethodWhenGetEmployeeList() {
        when(employeeRepositoryMock.getEmployeeList()).thenReturn(DEFAULT_EMPLOYEE_LIST);

        Assertions.assertEquals(DEFAULT_EMPLOYEE_LIST, out.getEmployeeList());
    }

    @Test
    public void shouldCallRepositoryMethodWhenCalculateTotalSumMonthSalary() {
        when(employeeRepositoryMock.calculateTotalSumMonthSalary()).thenReturn(DEFAULT_TOTAL_MONTH_SALARY_SUMMARY);

        Assertions.assertEquals(DEFAULT_TOTAL_MONTH_SALARY_SUMMARY, out.calculateTotalSumMonthSalary());
    }

    @Test
    public void shouldCallRepositoryMethodWhenFindEmployeeWithMinSalaryInDepartment() {
        when(employeeRepositoryMock.findEmployeeWithMinSalaryInDepartment(DEFAULT_EMPLOYEE_IDDEPARTMENT)).
                thenReturn(DEFAULT_LIST_OF_EMPLOYEES_WITH_MIN_MAX_SALARY_IN_DEPT);

        Assertions.assertEquals(DEFAULT_LIST_OF_EMPLOYEES_WITH_MIN_MAX_SALARY_IN_DEPT,
                out.findEmployeeWithMinSalaryInDepartment(DEFAULT_EMPLOYEE_IDDEPARTMENT));
    }

    @Test
    public void shouldCallRepositoryMethodWhenFindEmployeeWithMaxSalaryInDepartment() {
        when(employeeRepositoryMock.findEmployeeWithMaxSalaryInDepartment(DEFAULT_EMPLOYEE_IDDEPARTMENT)).
                thenReturn(DEFAULT_LIST_OF_EMPLOYEES_WITH_MIN_MAX_SALARY_IN_DEPT);

        Assertions.assertEquals(DEFAULT_LIST_OF_EMPLOYEES_WITH_MIN_MAX_SALARY_IN_DEPT,
                out.findEmployeeWithMaxSalaryInDepartment(DEFAULT_EMPLOYEE_IDDEPARTMENT));
    }

    @Test
    public void shouldCallRepositoryMethodWhenFindAllEmployeesByIdDepartment() {
        when(employeeRepositoryMock.findAllEmployeesByIdDepartment(DEFAULT_EMPLOYEE_IDDEPARTMENT)).
                thenReturn(DEFAULT_LIST_OF_EMPLOYEES_WITH_MIN_MAX_SALARY_IN_DEPT);

        Assertions.assertEquals(DEFAULT_LIST_OF_EMPLOYEES_WITH_MIN_MAX_SALARY_IN_DEPT,
                out.findAllEmployeesByIdDepartment(DEFAULT_EMPLOYEE_IDDEPARTMENT));
    }

    @Test
    public void shouldCallRepositoryMethodWhenSortListOfEmployeesByDepartment() {
        when(employeeRepositoryMock.sortListOfEmployeesByDepartment()).
                thenReturn(DEFAULT_EMPLOYEE_LIST);

        Assertions.assertEquals(DEFAULT_EMPLOYEE_LIST,
                out.sortListOfEmployeesByDepartment());
    }

    @Test
    public void shouldThrowExceptionWhenRepositoryThrowExceptionsWithAddEmployeeMethod() {
        when(employeeRepositoryMock.addEmployee(anyString(), anyString(), anyInt(), anyInt())).
                thenThrow(EmployeeWrongNameException.class);

        Assertions.assertThrows(EmployeeWrongNameException.class, () -> out.addEmployee(
                DEFAULT_EMPLOYEE_LASTNAME,
                DEFAULT_EMPLOYEE_FIRSTNAME,
                DEFAULT_EMPLOYEE_IDDEPARTMENT,
                DEFAULT_EMPLOYEE_SALARYPERMONTH));
    }

    @Test
    public void shouldThrowExceptionWhenRepositoryThrowExceptionsWithRemoveEmployeeMethod() {
        when(employeeRepositoryMock.removeEmployee(anyString(), anyString())).
                thenThrow(EmployeeNotFoundException.class);

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(
                DEFAULT_EMPLOYEE_LASTNAME,
                DEFAULT_EMPLOYEE_FIRSTNAME));
    }

    @Test
    public void shouldThrowExceptionWhenRepositoryThrowWrongNameExceptionsWithFindEmployeeMethod() {
        when(employeeRepositoryMock.findEmployee(anyString(), anyString())).
                thenThrow(EmployeeWrongNameException.class);

        Assertions.assertThrows(EmployeeWrongNameException.class, () -> out.findEmployee(
                DEFAULT_EMPLOYEE_LASTNAME,
                DEFAULT_EMPLOYEE_FIRSTNAME));
    }

    @Test
    public void shouldThrowExceptionWhenRepositoryThrowEmployeeNotFoundExceptionsWithFindEmployeeMethod() {
        when(employeeRepositoryMock.findEmployee(anyString(), anyString())).
                thenThrow(EmployeeNotFoundException.class);

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(
                DEFAULT_EMPLOYEE_LASTNAME,
                DEFAULT_EMPLOYEE_FIRSTNAME));
    }

}

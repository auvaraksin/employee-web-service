package pro.sky.employeewebservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.employeewebservice.data.Employee;
import pro.sky.employeewebservice.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployeeToList(@RequestParam("lastName") String lastName,
                                      @RequestParam("firstName") String firstName,
                                      @RequestParam("department") Integer idDepartment,
                                      @RequestParam("salary") Integer salaryPerMonth) {
        return employeeService.addEmployee(lastName, firstName, idDepartment, salaryPerMonth);
    }

    @GetMapping("/remove")
    public Employee removeEmployeeFromList(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.removeEmployee(lastName, firstName);
    }

    @GetMapping("/find-employee")
    public Employee findEmployeeInList(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping("/employeelist")
    public List<Employee> printEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/total-salary-per-month")
    public String showTotalSumMonthSalary() {
        return employeeService.calculateTotalSumMonthSalary();
    }

    @GetMapping("/departments/max-salary")
    public List<Employee> createListOfEmployeesWithMaxSalaryInDepartment(@RequestParam Integer idDepartment) {
        return employeeService.findEmployeeWithMaxSalaryInDepartment(idDepartment);
    }

    @GetMapping("/departments/min-salary")
    public List<Employee> createListOfEmployeesWithMinSalaryInDepartment(@RequestParam Integer idDepartment) {
        return employeeService.findEmployeeWithMinSalaryInDepartment(idDepartment);
    }

    @GetMapping(value = {"/departments/all",  "/departments/all/{idDepartment}"})
    public List<Employee> createListOfEmployees(@PathVariable(required = false) Integer idDepartment) {
        if (idDepartment != null) {
            return employeeService.findAllEmployeesByIdDepartment(idDepartment);
        } else {
            return employeeService.sortListOfEmployeesByDepartment();
        }
    }

}

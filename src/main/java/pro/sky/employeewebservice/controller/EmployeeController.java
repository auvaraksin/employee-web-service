package pro.sky.employeewebservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.employeewebservice.data.Employee;
import pro.sky.employeewebservice.service.impl.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final DepartmentService departmentService;

    public EmployeeController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/add")
    public Employee addEmployeeToList(@RequestParam("lastName") String lastName,
                                      @RequestParam("firstName") String firstName,
                                      @RequestParam("department") Integer idDepartment,
                                      @RequestParam("salary") Integer salaryPerMonth) {
        return departmentService.addEmployee(lastName, firstName, idDepartment, salaryPerMonth);
    }

    @GetMapping("/remove")
    public Employee removeEmployeeFromList(@RequestParam String lastName, @RequestParam String firstName) {
        return departmentService.removeEmployee(lastName, firstName);
    }

    @GetMapping("/find-employee")
    public Employee findEmployeeInList(@RequestParam String lastName, @RequestParam String firstName) {
        return departmentService.findEmployee(lastName, firstName);
    }

    @GetMapping("/employeelist")
    public List<Employee> printEmployeeList() {
        return departmentService.getEmployeeList();
    }

    @GetMapping("/total-salary-per-month")
    public String showTotalSumMonthSalary() {
        return departmentService.calculateTotalSumMonthSalary();
    }

    @GetMapping("/departments/max-salary")
    public List<Employee> createListOfEmployeesWithMaxSalaryInDepartment(@RequestParam Integer idDepartment) {
        return departmentService.findEmployeeWithMaxSalaryInDepartment(idDepartment);
    }

    @GetMapping("/departments/min-salary")
    public List<Employee> createListOfEmployeesWithMinSalaryInDepartment(@RequestParam Integer idDepartment) {
        return departmentService.findEmployeeWithMinSalaryInDepartment(idDepartment);
    }

    @GetMapping(value = {"/departments/all",  "/departments/all/{idDepartment}"})
    public List<Employee> createListOfEmployees(@PathVariable(required = false) Integer idDepartment) {
        if (idDepartment != null) {
            return departmentService.findAllEmployeesByIdDepartment(idDepartment);
        } else {
            return departmentService.sortListOfEmployeesByDepartment();
        }
    }

}

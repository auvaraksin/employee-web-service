package pro.sky.employeewebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public Employee addEmployeeToList(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.addEmployee(lastName, firstName);
    }

    @GetMapping("/remove")
    public Employee removeEmployeeFromList(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.removeEmployee(lastName, firstName);
    }

    @GetMapping("/find")
    public Employee findEmployeeInList(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping("/employeelist")
    public List<Employee> printEmployeeList() {
        return employeeService.getEmployeeList();
    }
}

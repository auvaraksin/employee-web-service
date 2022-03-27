package pro.sky.employeewebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployeeToList(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return EmployeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployeeFromList(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return EmployeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployeeInList(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return EmployeeService.findEmployee(firstName, lastName);
    }
}

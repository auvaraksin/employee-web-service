package pro.sky.employeewebservice;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    static Employee[] employees = new Employee[3];
    static int counter = 0;

    public static Employee addEmployee(String firstName, String lastName) {
        if (counter < employees.length) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[i].getFirstName().equals(firstName) &&
                            employees[i].getLastName().equals(lastName)) {
                        throw new NullPointerException();
                    }
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName);
                counter++;
                return new Employee(firstName, lastName);
            }
        }
        return new Employee(firstName, lastName);
    }

    public static Employee removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getFirstName().equals(firstName) &&
                        employees[i].getLastName().equals(lastName)) {
                    employees[i] = null;
                    counter--;
                    return new Employee(firstName, lastName);
                }
            } else throw new NullPointerException();
        }
        return new Employee(firstName, lastName);
    }
    public static Employee findEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getFirstName().equals(firstName) &&
                        employees[i].getLastName().equals(lastName)) {
                    return new Employee(firstName, lastName);
                }
            } else throw new NullPointerException();
        }
        return new Employee(firstName, lastName);
    }
}
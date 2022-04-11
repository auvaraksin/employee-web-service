package pro.sky.employeewebservice.data;

import java.util.Objects;

public class Employee {
    private String lastName;
    private String firstName;
    private Integer idDepartment;
    private Integer salaryPerMonth;

    public Employee(String lastName, String firstName, Integer idDepartment, Integer salaryPerMonth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idDepartment = idDepartment;
        this.salaryPerMonth = salaryPerMonth;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public Integer getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public void setSalaryPerMonth(Integer salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public String toString() {
        return ("lastName: " + lastName
                + ", firstName: " + firstName
                + ", idDepartment: " + idDepartment
                + ", salary: " + salaryPerMonth + " rub/month");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return lastName.equals(employee.lastName)
                && firstName.equals(employee.firstName)
                && idDepartment.equals(employee.idDepartment)
                && salaryPerMonth.equals(employee.salaryPerMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, idDepartment, salaryPerMonth);
    }

}

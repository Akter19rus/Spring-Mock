package Spring.Mock.model;

import java.util.Objects;

import static org.apache.tomcat.util.IntrospectionUtils.capitalize;

public class EmployeesModel {
    private String firstName;
    private String lastName;
    private int salary;
    private int department;
    private String fullName;

    public EmployeesModel(String firstName, String lastName, int salary, int department) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return "Имя Фамилия - " + this.firstName + " " + this.lastName + "\t";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesModel employees = (EmployeesModel) o;
        return salary == employees.salary
                && department == employees.department
                && Objects.equals(firstName, employees.firstName)
                && Objects.equals(lastName, employees.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }
}
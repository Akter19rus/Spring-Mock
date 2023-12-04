package Spring.Mock.service;

import Spring.Mock.model.EmployeesModel;

import java.util.Collection;

public interface EmployeeService {
    EmployeesModel addEmpl(String firstName, String lastName, int salary, int department);

    String deletedEmpl(String firstName, String lastName, int salary, int department);

    EmployeesModel searchEmpl(String firstName, String lastName, int salary, int department);

    Collection<EmployeesModel> fullList();
}
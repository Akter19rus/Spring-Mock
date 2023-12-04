package Spring.Mock.service;

import Spring.Mock.model.EmployeesModel;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<EmployeesModel> getFullDepartment(int department);

    EmployeesModel getMaxSalaryInDepartment(int department);

    EmployeesModel getMinSalaryInDepartment(int department);

    Map<Integer, List<EmployeesModel>> getFullDep();

    Double getSumSalaryForDepartment(int department);
}

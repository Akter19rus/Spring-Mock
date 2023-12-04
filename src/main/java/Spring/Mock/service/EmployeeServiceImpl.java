package Spring.Mock.service;

import Spring.Mock.Exceptions.EmployeeAlreadyAddedException;
import Spring.Mock.Exceptions.EmployeeInvalidInput;
import Spring.Mock.Exceptions.EmployeeNotFoundException;
import Spring.Mock.model.EmployeesModel;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, EmployeesModel> employees = new HashMap();

    @Override
    public EmployeesModel addEmpl(String firstName, String lastName, int salary, int department) {
        validationInput(firstName, lastName);

        EmployeesModel emp = new EmployeesModel(firstName, lastName, salary, department);
        if (this.employees.containsKey(emp.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует!");
        } else {
            this.employees.put(emp.getFullName(), emp);
        }
        return emp;
    }

    @Override
    public String deletedEmpl(String firstName, String lastName, int salary, int department) {
        validationInput(firstName, lastName);

        EmployeesModel emp = new EmployeesModel(firstName, lastName, salary, department);
        if (this.employees.containsKey(emp.getFullName())) {
            this.employees.remove(emp.getFullName());
            return "Успешное удаление сотрудника!";
        } else {
            throw new EmployeeNotFoundException("Cотрудника не существует!");
        }
    }

    @Override
    public EmployeesModel searchEmpl(String firstName, String lastName, int salary, int department) {
        validationInput(firstName, lastName);

        EmployeesModel emp = new EmployeesModel(firstName, lastName, salary, department);
        if (this.employees.containsKey(emp.getFullName())) {
            return (EmployeesModel) this.employees.get(emp.getFullName());
        } else {
            throw new EmployeeNotFoundException("Cотрудника не существует!");
        }
    }

    @Override
    public Collection<EmployeesModel> fullList() {
        return Collections.unmodifiableCollection(this.employees.values());
    }

    private void validationInput(String firstName, String lastName) {
        if (!isAlpha(firstName) && isAlpha(lastName)) {
            throw new EmployeeInvalidInput("Ошибка ввода!");
        }
    }
}

package Spring.Mock;

import Spring.Mock.model.EmployeesModel;
import Spring.Mock.service.EmployeeService;
import Spring.Mock.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import Spring.Mock.Exceptions.EmployeeAlreadyAddedException;
import Spring.Mock.Exceptions.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmployeeServiceTest {
    private EmployeeService out;

    private final EmployeesModel ONE_EMPLOYEE = new EmployeesModel("Джейсон",
            "Стетхем", 400_000, 1);
    private final EmployeesModel TWO_EMPLOYEE = new EmployeesModel("Александра",
            "Даддарио", 370_000, 1);
    private final EmployeesModel THREE_EMPLOYEE = new EmployeesModel("Александр",
            "Петров", 200_000, 2);


    @BeforeEach
    void setOut() {
        out = new EmployeeServiceImpl();
    }

    @Test
    void correctAddEmpl() {
        EmployeesModel add = out.addEmpl(
                ONE_EMPLOYEE.getFirstName(),
                ONE_EMPLOYEE.getLastName(),
                ONE_EMPLOYEE.getSalary(),
                ONE_EMPLOYEE.getDepartment()
        );
        assertEquals(ONE_EMPLOYEE, add);
        assertEquals(1, out.fullList().size());
    }

    @Test
    void verificationAlreadyAddedException() {
        out.addEmpl(
                TWO_EMPLOYEE.getFirstName(),
                TWO_EMPLOYEE.getLastName(),
                TWO_EMPLOYEE.getSalary(),
                TWO_EMPLOYEE.getDepartment()
        );
        Assertions.assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> out.addEmpl(
                        TWO_EMPLOYEE.getFirstName(),
                        TWO_EMPLOYEE.getLastName(),
                        TWO_EMPLOYEE.getSalary(),
                        TWO_EMPLOYEE.getDepartment())
        );
    }
    @Test
    void verificationNotFoundException() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                ()-> out.deletedEmpl(
                        THREE_EMPLOYEE.getFirstName(),
                        THREE_EMPLOYEE.getLastName(),
                        THREE_EMPLOYEE.getSalary(),
                        THREE_EMPLOYEE.getDepartment()
                )
        );
    }
    @Test
    void correctDeletEmpl() {
        out.addEmpl(
                ONE_EMPLOYEE.getFirstName(),
                ONE_EMPLOYEE.getLastName(),
                ONE_EMPLOYEE.getSalary(),
                ONE_EMPLOYEE.getDepartment()
        );
        assertEquals(1, out.fullList().size());
        out.deletedEmpl(
                ONE_EMPLOYEE.getFirstName(),
                ONE_EMPLOYEE.getLastName(),
                ONE_EMPLOYEE.getSalary(),
                ONE_EMPLOYEE.getDepartment()
        );
        assertEquals(0,out.fullList().size());
    }
    @Test
    void correctSearchEmpl () {
        out.addEmpl(
                TWO_EMPLOYEE.getFirstName(),
                TWO_EMPLOYEE.getLastName(),
                TWO_EMPLOYEE.getSalary(),
                TWO_EMPLOYEE.getDepartment()
        );
        EmployeesModel expected = new EmployeesModel(
                TWO_EMPLOYEE.getFirstName(),
                TWO_EMPLOYEE.getLastName(),
                TWO_EMPLOYEE.getSalary(),
                TWO_EMPLOYEE.getDepartment()
        );
        EmployeesModel result = out.searchEmpl(
                TWO_EMPLOYEE.getFirstName(),
                TWO_EMPLOYEE.getLastName(),
                TWO_EMPLOYEE.getSalary(),
                TWO_EMPLOYEE.getDepartment()
        );
        assertEquals(expected, result);

    }
}

package Spring.Mock;

import Spring.Mock.Exceptions.EmployeeNotFoundException;
import Spring.Mock.model.EmployeesModel;
import Spring.Mock.service.DepartmentServiceImpl;
import Spring.Mock.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeServiceImpl employeeServiceImpl;
    @InjectMocks
    private DepartmentServiceImpl out;

    private final EmployeesModel MAX_SALARY_EMPLOYEE = new EmployeesModel(
            "Ингрид",
            "Олеринская",
            999_999,
            1);

    private final EmployeesModel MIN_SALARY_EMPLOYEE = new EmployeesModel(
            "Дмитрий",
            "Нагиев",
            99_999,
            1);
    private final List<EmployeesModel> EMPLOYEES = List.of(
            MAX_SALARY_EMPLOYEE,
            MIN_SALARY_EMPLOYEE
    );

    @BeforeEach
    void setOut() {
        when(employeeServiceImpl.fullList()).thenReturn(EMPLOYEES);
    }

    @Test
    void correctDepart() {
        assertIterableEquals(out.getFullDepartment(1), EMPLOYEES);

    }

    @Test
    void correctFullDepart() {
        assertTrue(out.getFullDep().containsValue(EMPLOYEES));

    }

    @Test
    void correctMaxSalary() {
        assertEquals(
                out.getMaxSalaryInDepartment(1), MAX_SALARY_EMPLOYEE
        );
        assertThrows(
                EmployeeNotFoundException.class,
                () -> out.getMaxSalaryInDepartment(2)
        );
    }

    @Test
    void correctMinSalary() {
        assertEquals(
                out.getMinSalaryInDepartment(1), MIN_SALARY_EMPLOYEE
        );
        assertThrows(
                EmployeeNotFoundException.class,
                () -> out.getMinSalaryInDepartment(2)
        );
    }

    @Test
    void correctSumSalary() {
        assertEquals(
                1_099_998, (double) out.getSumSalaryForDepartment(1)
        );
    }
}

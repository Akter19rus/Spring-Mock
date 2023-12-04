package Spring.Mock.controllers;

import Spring.Mock.model.EmployeesModel;
import Spring.Mock.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/employees")
    public Map<Integer, List<EmployeesModel>> getFullDep() {
        return departmentService.getFullDep();
    }

    @GetMapping("/{id}/employees")
    public List<EmployeesModel> getFullDepartment(@RequestParam int department) {
        return departmentService.getFullDepartment(department);
    }


    @GetMapping("/{id}/salary/max")
    public EmployeesModel getMaxSalaryInDepartment(@RequestParam int department) {
        return departmentService.getMaxSalaryInDepartment(department);
    }

    @GetMapping("/{id}/salary/min")
    public EmployeesModel getMinSalaryInDepartment(@RequestParam int department) {
        return departmentService.getMinSalaryInDepartment(department);
    }

    @GetMapping("/{id}/salary/sum")
    public Double getSumSalaryForDepartment(@PathVariable("id") int department) {
        return departmentService.getSumSalaryForDepartment(department);
    }
}

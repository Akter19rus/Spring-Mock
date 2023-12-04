package Spring.Mock.controllers;

import Spring.Mock.model.EmployeesModel;
import Spring.Mock.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmplController {
    public final EmployeeService empl;

    public EmplController(EmployeeService empl) {
        this.empl = empl;
    }

    @GetMapping
    public Collection<EmployeesModel> fullEmpl() {
        return this.empl.fullList();
    }

    @GetMapping(path = "/add")
    public EmployeesModel addEmployee(@RequestParam("firstname") String firstName,
                                      @RequestParam("lastname") String lastName,
                                      @RequestParam("salary") int salary,
                                      @RequestParam("department") int department) {
        return this.empl.addEmpl(firstName, lastName, salary, department);
    }

    @GetMapping(path = "/remove")
    public String removeEmpl(@RequestParam("firstname") String firstName,
                             @RequestParam("lastname") String lastName,
                             @RequestParam("salary") int salary,
                             @RequestParam("department") int department) {
        return this.empl.deletedEmpl(firstName, lastName, salary, department);
    }

    @GetMapping(path = "/find")
    public EmployeesModel findEmpl(@RequestParam("firstname") String firstName,
                                   @RequestParam("lastname") String lastName,
                                   @RequestParam("salary") int salary,
                                   @RequestParam("department") int department) {
        return this.empl.searchEmpl(firstName, lastName, salary, department);
    }
}

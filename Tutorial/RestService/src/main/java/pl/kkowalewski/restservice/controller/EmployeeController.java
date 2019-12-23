package pl.kkowalewski.restservice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kkowalewski.restservice.exception.EmployeeNotFoundException;
import pl.kkowalewski.restservice.model.Employee;
import pl.kkowalewski.restservice.repository.EmployeeRepository;

import java.util.List;

import static pl.kkowalewski.restservice.constant.Constants.PATH_EMPLOYEES;
import static pl.kkowalewski.restservice.constant.Constants.PATH_EMPLOYEES_ID;

@RestController
public class EmployeeController {

    /*------------------------ FIELDS REGION ------------------------*/
    private final EmployeeRepository employeeRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(PATH_EMPLOYEES)
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping(PATH_EMPLOYEES_ID)
    public Employee getById(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Could not find employee id: " + id));
    }

    @PostMapping(PATH_EMPLOYEES)
    public Employee add(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping(PATH_EMPLOYEES_ID)
    public Employee update(@RequestBody Employee employee, @PathVariable Long id) {
        return employeeRepository.findById(id)
                .map((it) -> {
                    it.setName(employee.getName());
                    it.setRole(employee.getRole());

                    return employeeRepository.save(it);
                }).orElseGet(() -> {
                    employee.setId(id);

                    return employeeRepository.save(employee);
                });
    }

    @DeleteMapping(PATH_EMPLOYEES_ID)
    public void delete(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}

package pl.kkowalewski.restservice.loader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kkowalewski.restservice.model.Employee;
import pl.kkowalewski.restservice.repository.EmployeeRepository;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    /*------------------------ FIELDS REGION ------------------------*/
    private final EmployeeRepository employeeRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private Employee prepareEmployee(Employee employee) {
        employeeRepository.save(employee);

        return employee;
    }

    @Override
    public void run(String... args) throws Exception {
        prepareEmployee(new Employee("Bilbo Baggins", "burglar"));
        prepareEmployee(new Employee("Frodo Baggins", "thief"));

        employeeRepository.findAll().forEach((it) -> log.info("Loading: " + it.toString()));
    }
}

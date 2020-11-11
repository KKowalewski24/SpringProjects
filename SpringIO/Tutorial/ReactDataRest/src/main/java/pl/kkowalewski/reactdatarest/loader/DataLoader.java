package pl.kkowalewski.reactdatarest.loader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kkowalewski.reactdatarest.model.Employee;
import pl.kkowalewski.reactdatarest.repository.EmployeeRepository;

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
        prepareEmployee(new Employee("Bilbo Baggins", "burglar", "ring bearer"));
        prepareEmployee(new Employee("Frodo Baggins", "thief", "porsche"));

        employeeRepository.findAll().forEach((it) -> log.info("Loading: " + it.toString()));
    }
}

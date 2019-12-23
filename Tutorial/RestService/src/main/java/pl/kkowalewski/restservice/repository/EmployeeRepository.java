package pl.kkowalewski.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kkowalewski.restservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

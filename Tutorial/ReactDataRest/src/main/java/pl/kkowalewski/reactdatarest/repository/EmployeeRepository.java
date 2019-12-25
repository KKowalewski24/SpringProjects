package pl.kkowalewski.reactdatarest.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkowalewski.reactdatarest.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}

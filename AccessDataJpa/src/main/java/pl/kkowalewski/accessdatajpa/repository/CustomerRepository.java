package pl.kkowalewski.accessdatajpa.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkowalewski.accessdatajpa.model.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}

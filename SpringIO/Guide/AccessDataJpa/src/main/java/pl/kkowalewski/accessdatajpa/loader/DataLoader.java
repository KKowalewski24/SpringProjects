package pl.kkowalewski.accessdatajpa.loader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kkowalewski.accessdatajpa.model.Customer;
import pl.kkowalewski.accessdatajpa.repository.CustomerRepository;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    /*------------------------ FIELDS REGION ------------------------*/
    private final CustomerRepository customerRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private Customer prepareCustomer(Customer customer) {
        customerRepository.save(customer);

        return customer;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer jack = prepareCustomer(new Customer("Jack", "Bauer"));
        Customer kim = prepareCustomer(new Customer("Kim", "Bauer"));
        Customer david = prepareCustomer(new Customer("David", "Palmer"));
        Customer michelle = prepareCustomer(new Customer("Michelle", "Dessler"));

        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        customerRepository.findAll().forEach((it) -> log.info(it.toString()));
        log.info("");

        log.info("Customer found with findById(1L):");
        log.info("--------------------------------");
        log.info(customerRepository.findById(1L).toString());

        log.info("Customer found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        customerRepository.findByLastName("Bauer").forEach((it) -> log.info(it.toString()));
        log.info("");
    }
}

package pl.kkowalewski.accessdatamongodb.loader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kkowalewski.accessdatamongodb.model.Customer;
import pl.kkowalewski.accessdatamongodb.repository.CustomerRepository;

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

    private void loadData() {
        Customer jack = prepareCustomer(new Customer("Jack", "Bauer"));
        Customer kim = prepareCustomer(new Customer("Kim", "Bauer"));
        Customer david = prepareCustomer(new Customer("David", "Palmer"));
        Customer michelle = prepareCustomer(new Customer("Michelle", "Dessler"));
    }

    private void displayData() {
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        customerRepository.findAll().forEach((it) -> log.info(it.toString()));
        log.info("");

        log.info("Customer found with findByFirstName('Jac'):\"");
        log.info("-------------------------------");
        Customer customer = customerRepository.findByFirstName("Jac");
        log.info(customer != null ? customer.toString() : null);
        log.info("");

        log.info("Customers found with findByLastName('Smith'):");
        log.info("-------------------------------");
        customerRepository.findByLastName("Smith").forEach((it) -> log.info(it.toString()));
        log.info("");
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
        displayData();
    }
}

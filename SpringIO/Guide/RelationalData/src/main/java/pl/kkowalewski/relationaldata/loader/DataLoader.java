package pl.kkowalewski.relationaldata.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pl.kkowalewski.relationaldata.RelationalDataApplication;
import pl.kkowalewski.relationaldata.model.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    /*------------------------ FIELDS REGION ------------------------*/
    private static final Logger log = LoggerFactory.getLogger(RelationalDataApplication.class);

    private final JdbcTemplate jdbcTemplate;

    /*------------------------ METHODS REGION ------------------------*/
    public DataLoader(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private void prepareTable() {
        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers" +
                "(id SERIAL, first_name VARCHAR(255),last_name VARCHAR(255))"
        );
    }

    private void loadData() {
        List<Object[]> names = Arrays
                .asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                .stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        names.forEach(it -> log.info("Inserting customer record for " + it));

        jdbcTemplate.batchUpdate(
                "INSERT INTO customers(first_name, last_name) VALUES (?,?)", names
        );
    }

    private void makeQuery() {

        log.info("Querying for customer records where first_name = 'Josh':");

        jdbcTemplate.query(
                "SELECT id, first_name,last_name FROM customers WHERE first_name=?",
                new Object[]{"Josh"},
                (rs, rowNumber) -> new Customer(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                )
        ).forEach(customer -> log.info(customer.toString()));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        prepareTable();
        loadData();
        makeQuery();
    }
}

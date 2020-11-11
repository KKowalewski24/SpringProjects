package pl.kkowalewski.batchservice.execution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pl.kkowalewski.batchservice.model.Person;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String QUERY = "SELECT first_name, last_name FROM people";
    private static final Logger log = LoggerFactory
            .getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    /*------------------------ METHODS REGION ------------------------*/
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");
            jdbcTemplate.query(QUERY,
                    (res, row) -> new Person(
                            res.getString(1),
                            res.getString(2))
            ).forEach((it) -> log.info("Found <" + it + "> in the database."));
        }
    }
}

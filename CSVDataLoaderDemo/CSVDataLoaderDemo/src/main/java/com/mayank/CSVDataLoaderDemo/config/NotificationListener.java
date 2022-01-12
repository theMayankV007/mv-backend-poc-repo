package com.mayank.CSVDataLoaderDemo.config;

import com.mayank.CSVDataLoaderDemo.dao.Voltage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NotificationListener(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED)
            LOGGER.info(" JOB FINISHED!!!, Time to verify results....");
        jdbcTemplate.query("SELECT volt, time from voltage", (rs, row) -> new Voltage(rs.getBigDecimal(1), rs.getDouble(2))
        ).forEach(voltage -> LOGGER.info("Found <" + voltage + "> in the database."));
    }
}

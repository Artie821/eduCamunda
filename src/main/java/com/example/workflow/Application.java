package com.example.workflow;

import org.camunda.bpm.spring.boot.starter.event.TaskEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.time.LocalTime;


@SpringBootApplication
public class Application implements LoggerInterface {

    private final LocalDate DATE = LocalDate.now();


    @EventListener(condition = "#event.eventName=='create'")
    public void onTaskCreatedEvent(TaskEvent event) {
        // handle immutable task event

        LocalTime time = LocalTime.now();

        LOGGER.info("handle task event " + event.getEventName() + " for task id " + event.getId() + " at " + DATE + " " + time);

    }

    @EventListener(condition = "#event.eventName=='complete'")
    public void onTaskCompletedEvent(TaskEvent event) {
        // handle immutable task event
        LocalTime time = LocalTime.now();

        LOGGER.info("handle task event " + event.getEventName() + " for task id " + event.getId() + " at " + DATE + " " + time);

    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

}
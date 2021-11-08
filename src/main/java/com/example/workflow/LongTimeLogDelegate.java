package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class LongTimeLogDelegate implements JavaDelegate, LoggerInterface {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOGGER.info("WHY ITS TAKING SO MUCH TIME TO PUT THIS DATA? " + execution.getProcessInstanceId());
    }
}

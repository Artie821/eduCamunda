package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SignalInterruptedLog implements JavaDelegate, LoggerInterface {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("ALL PROCESSES ARE INTERRUPTED BY SIGNAL EVEN AND WILL BE STOPPED");
    }
}

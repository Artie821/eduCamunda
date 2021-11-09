package com.example.workflow;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import java.time.LocalTime;

public class ActivityStartEndListener implements ExecutionListener, LoggerInterface {

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {

        LocalTime lt = LocalTime.now();

        RuntimeService runtimeService = delegateExecution.getProcessEngine().getRuntimeService();

        if (lt.getMinute() % 2 == 0) {
            runtimeService.setVariable(delegateExecution.getId(), "duration", "R/PT2M");
        } else {
            runtimeService.setVariable(delegateExecution.getId(), "duration", "R/PT5M");
        }

        LOGGER.info(delegateExecution.getEventName() + " " + delegateExecution.getProcessInstanceId());
    }

}



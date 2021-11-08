package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class ActivityStartEndListener implements ExecutionListener, LoggerInterface {

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {

        LOGGER.info(delegateExecution.getEventName() + " " + delegateExecution.getProcessInstanceId());
    }
}

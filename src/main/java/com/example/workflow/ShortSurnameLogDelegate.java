package com.example.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class ShortSurnameLogDelegate implements JavaDelegate, LoggerInterface {

    @Override
    public void execute(DelegateExecution execution) throws Exception {


        if (((String) execution.getVariable("surnameForm")).equalsIgnoreCase("er")) {
            LOGGER.info("ERROR ON PROCESS " + execution.getProcessInstanceId());
            throw new BpmnError("SurnameError", "This is really bad surname ");
        } else {
            LOGGER.info("TOO SHORT SURNAME! SURNAME WILL BE CHANGED TO LongUserSurname");
            execution.setVariable("surnameForm", "LongUserSurname");
        }


    }
}

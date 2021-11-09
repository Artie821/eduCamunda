package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
public class LoggerDelegate implements JavaDelegate, LoggerInterface {


    public void execute(DelegateExecution execution) throws Exception {

        LOGGER.info("\n\n  ... LoggerDelegate invoked by "
                + "\n processDefinitionId=" + execution.getProcessDefinitionId()
                + ",\n activtyId=" + execution.getCurrentActivityId()
                + ",\n activtyName='" + execution.getCurrentActivityName() + "'"
                + ",\n processInstanceId=" + execution.getProcessInstanceId()
                + ",\n businessKey=" + execution.getProcessBusinessKey()
                + ",\n executionId=" + execution.getId()
                + ",\n userNameLog=" + execution.getVariable("userName")
                + ",\n userSurNameLog=" + execution.getVariable("surnameForm")
                + " \n\n");

    }

}

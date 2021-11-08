package com.example.workflow;

import java.util.logging.Logger;

public interface LoggerInterface {
    Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
}

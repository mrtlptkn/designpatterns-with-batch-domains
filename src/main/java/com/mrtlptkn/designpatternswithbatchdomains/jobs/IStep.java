package com.mrtlptkn.designpatternswithbatchdomains.jobs;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.command.IStepCommand;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.command.RetryStepCommand;

public interface IStep {
    String getId();
    String getStepName();
    StepExecution execute();
}

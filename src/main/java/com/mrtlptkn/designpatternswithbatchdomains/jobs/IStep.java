package com.mrtlptkn.designpatternswithbatchdomains.jobs;

public interface IStep {
    String getId();
    String getStepName();
    StepExecution execute();
}

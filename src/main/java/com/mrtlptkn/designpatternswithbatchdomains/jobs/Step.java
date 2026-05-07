package com.mrtlptkn.designpatternswithbatchdomains.jobs;

import lombok.Getter;

import java.util.UUID;

public class Step implements IStep {

    @Getter
    private final String id;

    @Getter
    private final String stepName;

    public Step(String stepName) {
        this.id = UUID.randomUUID().toString();
        this.stepName = stepName;
    }


    @Override
    public StepExecution execute() {
        StepExecution stepExecution = new StepExecution(this);

        try {
            System.out.println("Executing step: " + stepName);
            stepExecution.setStatus(BatchStatus.Completed);

        } catch (Exception e) {
            System.out.println("Error executing step: " + stepName);
            stepExecution.setStatus(BatchStatus.Failed);
            throw new RuntimeException(e);
        }

        System.out.println("Step '" + stepName + "' execution completed with status: " + stepExecution.getStatus());

        return stepExecution;

    }


}

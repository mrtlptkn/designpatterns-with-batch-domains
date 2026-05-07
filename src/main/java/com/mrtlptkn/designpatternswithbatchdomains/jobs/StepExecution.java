package com.mrtlptkn.designpatternswithbatchdomains.jobs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

public class StepExecution {

    @Getter
    private final String stepId;

    @Getter
    private final String stepName;

    @Getter
    private final LocalDate createdAt;

    @Setter
    @Getter
    private BatchStatus status; // step çalışırken hata alabilir yada başarılı olabilir.


    public StepExecution(Step step) {
        this.stepId = step.getId();
        this.stepName = step.getStepName();
        this.status = BatchStatus.Started;
        this.createdAt = LocalDate.now();
    }

}

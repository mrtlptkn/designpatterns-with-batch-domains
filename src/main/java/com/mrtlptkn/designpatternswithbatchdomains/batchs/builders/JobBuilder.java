package com.mrtlptkn.designpatternswithbatchdomains.batchs.builders;

import com.mrtlptkn.designpatternswithbatchdomains.jobs.IJob;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IStep;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.Job;

import java.lang.reflect.Field;

public class JobBuilder implements IJobBuilder  {
    private final IJob job;

    public JobBuilder(String jobName) {
        this.job = new Job(jobName);
    }

    @Override
    public IJob build() {
        return this.job;
    }

    @Override
    public IJobBuilder start(IStep step) {
        this.job.addStep(step);
        return this;
    }

    @Override
    public IJobBuilder next(IStep step) {
        this.job.addStep(step);
        return this;
    }
}

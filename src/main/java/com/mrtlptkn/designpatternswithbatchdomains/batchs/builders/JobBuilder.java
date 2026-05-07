package com.mrtlptkn.designpatternswithbatchdomains.batchs.builders;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.factoryMethod.JobType;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.factoryMethod.JobFactory;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IJob;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IStep;


public class JobBuilder implements IJobBuilder  {
    private final IJob job;

    public JobBuilder(String jobName, JobType jobType) {
        // JobFactory üzerinden herhangi bir job'a göre çalışma esnekliği kazanmış oldu.
        this.job = JobFactory.createJob(jobType,jobName);
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

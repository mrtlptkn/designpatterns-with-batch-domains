package com.mrtlptkn.designpatternswithbatchdomains.jobs;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

// Joblar run edilince JobExecution olarak kaydedilirdi
public class JobExecution {

    @Getter
    private final String id;

    @Getter
    private final String jobId;

    @Getter
    private final String jobName;

    @Getter
    private final String JobParameterId;

    @Setter
    @Getter
    private BatchStatus status;


    public JobExecution(Job job, JobParameters jobParameters) {
        this.id = UUID.randomUUID().toString();
        this.jobId = job.getId();
        this.jobName = job.getJobName();
        this.JobParameterId = jobParameters.getId();
        this.status = BatchStatus.Started;
    }


}

package com.mrtlptkn.designpatternswithbatchdomains.jobs;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class SimpleJob implements IJob {

    @Getter
    private final String Id;

    @Getter
    private final String jobName; // Job Name olmadan job tanımlanamaz

    @Getter
    private final List<IStep> steps; // Job'un adımlarını tutar

    public SimpleJob(String jobName) {
        this.Id = UUID.randomUUID().toString();
        this.jobName = jobName;
        this.steps = new ArrayList<>(); // Her jobın en az çalıştırılacak bir adaet step olması lazım
    }


    @Override
    public JobExecution execute(JobParameters parameters) {
        System.out.println("Executing Job: " + jobName);
        System.out.println("Starting jobExecution of Job: " + jobName + " with parameters: " + parameters);

        JobExecution jobExecution = new JobExecution(this,parameters);

        if(this.steps.isEmpty()){
            jobExecution.setStatus(BatchStatus.Failed);
            throw new IllegalStateException("Job '" + jobName + "' has no steps defined.");
        }

        for (IStep step : steps) {

           StepExecution stepExecution =  step.execute();
           System.out.println(stepExecution.getStepName() + " step jobExecution status: " + stepExecution.getStatus());

           // Eğer step jobExecution durumda hata olursa diğer steplere geçmeden job failed yap. Job jobExecution nesnesini döndür.
           if(stepExecution.getStatus() == BatchStatus.Failed) {
               jobExecution.setStatus(BatchStatus.Failed);
               System.out.println("Job '" + jobName + "' jobExecution failed at step: " + stepExecution.getStepName());
               return jobExecution;
           }
        }

        jobExecution.setStatus(BatchStatus.Completed);
        System.out.println("Job '" + jobName + "' jobExecution completed.");

        return jobExecution;
    }

    @Override
    public void addStep(IStep step) {
        this.steps.add(step);
    }


}

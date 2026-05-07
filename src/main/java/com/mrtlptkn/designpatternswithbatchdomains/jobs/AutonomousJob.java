package com.mrtlptkn.designpatternswithbatchdomains.jobs;

import java.util.List;



// IJob dan türeyen şuan için 2 tane Job var -> SimpleJob -> Otonom işlemler için AutonomousJob -> Cron tabanlı çalışsın her 5 dakikada bir çalışma gibi yapıları barındırsın.
public class AutonomousJob  implements IJob{

    private final String jobName;

    public AutonomousJob(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String getId() {
        return "";
    }

    @Override
    public String getJobName() {
        return "";
    }

    @Override
    public JobExecution execute(JobParameters jobParameters) {
        return null;
    }

    @Override
    public void addStep(IStep step) {

    }

    @Override
    public List<IStep> getSteps() {
        return List.of();
    }
}

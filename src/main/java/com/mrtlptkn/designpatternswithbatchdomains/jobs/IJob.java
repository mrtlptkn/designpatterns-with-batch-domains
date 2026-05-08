package com.mrtlptkn.designpatternswithbatchdomains.jobs;

import java.util.List;

// Veri tabanında her bir job kaydı bir JobInstance nesnesi ama program tarafında bizim için bunlar
// Job
public interface IJob {
    String getId();
    String getJobName();
    JobExecution execute(JobParameters jobParameters); // Her job calıştığında bir job execution nesnesi döner
    // Composition Pattern: Job, Step'lerden oluşur
    void addStep(IStep step); // IStep interface ekle
    List<IStep> getSteps(); // Job Steps

    // Job Listener ekleyelim.
}

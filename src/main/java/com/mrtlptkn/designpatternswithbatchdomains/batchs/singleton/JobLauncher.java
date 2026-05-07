package com.mrtlptkn.designpatternswithbatchdomains.batchs.singleton;

import com.mrtlptkn.designpatternswithbatchdomains.jobs.IJob;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.JobExecution;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.JobParameters;

// THREAD SAFE
public class JobLauncher {
        private static volatile JobLauncher instance;
        private static final Object lock = new Object(); // nesneye farklı threadlerden erişim olursa farklı bir thread üzerinden erişim engellemek için lock nesnesi oluşturduk

    private JobLauncher() {
        // private constructor to prevent instantiation
    }


    public static JobLauncher getInstance() {
        if (instance == null) { // ilk kontrol, instance zaten oluşturulmuş mu?
            synchronized (lock) { // lock ile senkronize ediyoruz
                if (instance == null) { // ikinci kontrol, başka bir thread tarafından instance oluşturulmuş mu?
                    instance = new JobLauncher(); // instance oluşturuluyor
                }
            }
        }
        return instance; // oluşturulan veya mevcut instance döndürülüyor
    }

    public JobExecution run(IJob job, JobParameters jobParameters){
        System.out.println("JobLauncher: Running job '" + job.getJobName() + "' with parameters: " + jobParameters);
        return job.execute(jobParameters);
    }

}

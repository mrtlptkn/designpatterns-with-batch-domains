package com.mrtlptkn.designpatternswithbatchdomains.batchs.factoryMethod;

import com.mrtlptkn.designpatternswithbatchdomains.jobs.AutonomousJob;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IJob;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.SimpleJob;



// Aynı aileden türüyen nesnelerin ilgili nesne tipine göre concrete sınıflarını subclasslarını üretmek.
// aslında slt sınıflar factory bir sınıf üzerinden üretebilmemizi sağlar.

public class JobFactory {


    public static IJob createJob(JobType jobType,String jobName) {

        return switch (jobType) {
            case Simple -> new SimpleJob(jobName);
            case Autonomous -> new AutonomousJob(jobName);
            default -> throw new IllegalArgumentException("Invalid job type: " + jobType);
        };

    }
}

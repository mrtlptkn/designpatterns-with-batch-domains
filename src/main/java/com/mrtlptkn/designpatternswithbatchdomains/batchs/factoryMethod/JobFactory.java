package com.mrtlptkn.designpatternswithbatchdomains.batchs.factoryMethod;

import com.mrtlptkn.designpatternswithbatchdomains.jobs.AutonomousJob;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IJob;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.SimpleJob;

// Aynı aileden türüyen nesnelerin ilgili nesne tipine göre concrete sınıflarını subclasslarını üretmek.
// aslında slt sınıflar factory bir sınıf üzerinden üretebilmemizi sağlar.

public class JobFactory implements IJobFactory {

    public String jobType;

    public JobFactory(String jobType) {
        this.jobType = jobType;
    }


    @Override
    public IJob createJob(String jobName) {

        if(jobType.equals("SimpleJob"))
        return new SimpleJob(jobName);
        else if(jobType.equals("AutonomousJob"))
        return new AutonomousJob(jobName);
        else
            throw new IllegalArgumentException("Geçersiz job türü: " + jobType);

    }
}

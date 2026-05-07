package com.mrtlptkn.designpatternswithbatchdomains.batchs.factoryMethod;

import com.mrtlptkn.designpatternswithbatchdomains.jobs.IJob;

public interface IJobFactory {
    IJob createJob(String jobName);
}

package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.builder;

import com.mrtlptkn.designpatternswithbatchdomains.jobs.IJob;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IStep;

public interface IJobBuilder {
    IJob build();
    IJobBuilder start(IStep step);
    IJobBuilder next(IStep step);
}

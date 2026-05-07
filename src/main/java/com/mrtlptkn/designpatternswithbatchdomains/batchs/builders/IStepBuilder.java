package com.mrtlptkn.designpatternswithbatchdomains.batchs.builders;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory.IitemProcessor;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory.IitemReader;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory.IitemWriter;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IStep;

// Step  -> Userclass okuyabilir Identity Class da okuyabilir, Role Class okuyabilir.


public interface IStepBuilder<T> {
    IStep build();
    IStepBuilder<T> withReader(IitemReader<T> iitemReader); // step içerisinde okuma işlemi yapıcam
    IStepBuilder<T> withWriter(IitemWriter<T> iitemWriter); // step içerisinde yazma işlemi yapıcam
    IStepBuilder<T> withProcessor(IitemProcessor<T> iitemProcessor); // step içerisinde işleme işlemi yapıcam
}

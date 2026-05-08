package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.builder;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemProcessor;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemReader;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemWriter;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IStep;

// Step  -> Userclass okuyabilir Identity Class da okuyabilir, Role Class okuyabilir.


public interface IStepBuilder<T> {
    IStep build();
    IStepBuilder<T> withReader(IitemReader<T> iitemReader); // step içerisinde okuma işlemi yapıcam
    IStepBuilder<T> withWriter(IitemWriter<T> iitemWriter); // step içerisinde yazma işlemi yapıcam
    IStepBuilder<T> withProcessor(IitemProcessor<T> iitemProcessor); // step içerisinde işleme işlemi yapıcam

    // builder oluşturuken kaç kez denenceği de girilsin istiyoruz.
    IStepBuilder<T> withRetry(int maxRetries);

}

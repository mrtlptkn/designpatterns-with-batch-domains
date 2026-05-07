package com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory;

// Abstract Factory
public interface IBatchingProcessingFactory<T> {
    IitemReader<T> createItemReader();
    IitemProcessor<T> createItemProcessor();
    IitemWriter<T> createItemWriter();
}

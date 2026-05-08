package com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.decorator;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemProcessor;


// Tüm decorator sınıfları buradan türer.

public abstract class ItemProcessorDecorator<T> implements IitemProcessor<T> {

    // base nesne üzerine özellik eklemek istiyoruz
    protected final IitemProcessor<T> baseDecoratedProcessor;

    public ItemProcessorDecorator(IitemProcessor<T> decoratedProcessor){
        this.baseDecoratedProcessor = decoratedProcessor;
    }

    @Override
    public T process(T item) {
        return baseDecoratedProcessor.process(item);
    }
}

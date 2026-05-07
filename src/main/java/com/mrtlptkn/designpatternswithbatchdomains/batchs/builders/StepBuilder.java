package com.mrtlptkn.designpatternswithbatchdomains.batchs.builders;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory.IitemProcessor;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory.IitemReader;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory.IitemWriter;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IStep;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.Step;

public class StepBuilder<T> implements IStepBuilder<T> {
    private final IStep step;
    private IitemReader<T> reader;
    private IitemWriter<T> writer;
    private IitemProcessor<T> processor;
    public StepBuilder(String stepName) {
        this.step = new Step(stepName);
    }
    @Override
    public IStep build() {
        return this.step;
    }
    @Override
    public IStepBuilder<T> withReader(IitemReader<T> iitemReader) {
        this.reader = iitemReader;
        return this;
    }
    @Override
    public IStepBuilder<T> withWriter(IitemWriter<T> iitemWriter) {
        this.writer = iitemWriter;
        return this;
    }
    @Override
    public IStepBuilder<T> withProcessor(IitemProcessor<T> iitemProcessor) {
        this.processor = iitemProcessor;
        return this;
    }
}

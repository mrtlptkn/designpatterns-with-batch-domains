package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.builder;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.command.RetryStepCommand;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemProcessor;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemReader;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemWriter;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IStep;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.Step;

public class StepBuilder<T> implements IStepBuilder<T> {
    private final Step<T> step;
    public StepBuilder(String stepName) {
        this.step = new Step(stepName);
    }
    @Override
    public IStep build() {
        return this.step;
    }
    @Override
    public IStepBuilder<T> withReader(IitemReader<T> iitemReader) { // method Injection
        this.step.setReader(iitemReader);
        // Step SetItemReader yapalım.
        return this;
    }
    @Override
    public IStepBuilder<T> withWriter(IitemWriter<T> iitemWriter) {
        this.step.setWriter(iitemWriter);
        return this;
    }
    @Override
    public IStepBuilder<T> withProcessor(IitemProcessor<T> iitemProcessor) {
        this.step.setProcessor(iitemProcessor);
        return this;
    }


}

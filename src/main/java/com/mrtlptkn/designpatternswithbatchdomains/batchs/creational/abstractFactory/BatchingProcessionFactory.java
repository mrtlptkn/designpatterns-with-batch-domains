package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory;

public abstract class BatchingProcessionFactory<T> implements IBatchingProcessingFactory<T> {

    protected final String filePath;
    protected Class<T> type;


    public BatchingProcessionFactory(String filePath, Class<T> type) {
        this.filePath = filePath;
        this.type = type;
    }

}

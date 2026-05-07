package com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory;

public class XmlBatchingProcessingFactory<T> extends BatchingProcessionFactory<T> implements IBatchingProcessingFactory<T> {

    public XmlBatchingProcessingFactory(String filePath, Class<T> type) {
        super(filePath, type);
    }

    @Override
    public IitemReader<T> createItemReader() {
        return new XmlItemReader<>(filePath, type);
    }

    @Override
    public IitemProcessor<T> createItemProcessor() {
        return new XmlItemProcessor<>();
    }

    @Override
    public IitemWriter<T> createItemWriter() {
        return new XMLItemWriter<>(filePath);
    }
}

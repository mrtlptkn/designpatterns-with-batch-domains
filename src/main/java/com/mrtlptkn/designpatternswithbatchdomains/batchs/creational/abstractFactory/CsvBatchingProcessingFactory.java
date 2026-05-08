package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory;


// CONCRETE FACTORY
public class CsvBatchingProcessingFactory<T>  extends BatchingProcessionFactory<T> implements IBatchingProcessingFactory<T> {


    public CsvBatchingProcessingFactory(String filePath, Class<T> type) {
        super(filePath, type);
    }

    @Override
    public IitemReader<T> createItemReader() {
        return new CsvItemReader<>(filePath, type);
    }

    @Override
    public IitemProcessor<T> createItemProcessor() {
        return new CSVItemProcessor<>();
    }

    @Override
    public IitemWriter<T> createItemWriter() {
        return new CsvItemWriter<>(filePath);
    }
}

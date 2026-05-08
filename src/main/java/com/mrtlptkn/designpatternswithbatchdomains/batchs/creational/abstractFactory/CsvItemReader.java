package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory;

import lombok.Getter;

import java.util.List;


// CONCRETE PRODUCT
public class CsvItemReader<T> implements IitemReader<T> {

    @Getter
    private final String filePath;
    private final Class<T> type;

    public CsvItemReader(String filePath, Class<T> type) {
        this.filePath = filePath;
        this.type = type;
    }


    @Override
    public List<T> read() {
        System.out.println(".csv uzantılı dosya okunur datalar T tipinde bir Listeye dönüştürülür");
        return List.of();
    }
}

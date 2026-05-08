package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory;

import java.util.List;


// CONCRETE PRODUCT
public class CsvItemWriter<T> implements IitemWriter<T> {

    private final String filePath; // Hangi dosyaya yazma işlemi yapılacak

    public CsvItemWriter(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public void write(List<T> items) {
        System.out.println("Listedeki verileri ise CSV dosyasına yazıcaz.");
        for (T item : items) {
            System.out.println(item.toString());
        }
    }
}

package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory;

import java.util.List;


// CONCRETE PRODUCT
public class XMLItemWriter<T> implements IitemWriter<T> {

    private final String filePath; // Hangi dosyaya yazma işlemi yapılacak

    public XMLItemWriter(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public void write(List<T> items) {
        // XML'e yazma işlemi burada gerçekleştirilir.
        System.out.println("Writing items to XML:");
        for (T item : items) {
            System.out.println("<item>" + item.toString() + "</item>");
        }
    }
}

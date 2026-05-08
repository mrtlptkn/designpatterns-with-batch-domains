package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory;

// CONCRETE PRODUCT
public class CSVItemProcessor<T> implements IitemProcessor<T> {
    @Override
    public T process(T item) { // Her bir item içersindeki bazı bilgileri güncelleyip geri döndüreceğiz ki ramdeki değer güncellensin. Örneğin CSV dosyasından okunan bir item'ın tarih formatını güncellemek gibi.
        System.out.println("Processing CSV item: " + item);
        return null;
    }
}

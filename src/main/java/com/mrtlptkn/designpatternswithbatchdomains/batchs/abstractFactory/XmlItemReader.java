package com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory;

import java.util.ArrayList;
import java.util.List;

public class XmlItemReader<T> implements IitemReader<T> {

    private final String filePath;
    private final Class<T> type;

    public XmlItemReader(String filePath, Class<T> type) {
        this.filePath = filePath;
        this.type = type;
    }

    @Override
    public List<T> read() {
        // XML dosyasından veri okuma işlemi burada gerçekleştirilir.
        System.out.println("XML dosyasından veri okunuyor...");
        return new ArrayList<>(); // Örnek olarak boş bir liste döndürülüyor.
    }
}

package com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.proxy;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.CSVItemProcessor;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.CsvItemReader;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


// CsvItemReader<T>  gerçek sınıf ->   implements IitemReader<T>
// CsvItemReaderProxy<T> proxy sınıf -> implements IitemReader<T>

public class CsvItemReaderProxy<T> implements IitemReader<T> {

    // Amaç : Proxy üzerinden realService gitmek.
    private CsvItemReader<T> realService;

    public CsvItemReaderProxy(CsvItemReader<T> realService){
        this.realService = realService;
    }


    @Override
    public List<T> read() { // proxy read

        // Before
        if(!fileExists(this.realService.getFilePath())){
            // Genelde yetki var mı
            // Genelde cached result döndür.
            throw new UnsupportedOperationException("Dosya erişim sağlanamıyor");
        }

        // After
        // Gerçek sınıfta Güvenlik loglama yapısı düşünülmemiştir. Yapıyı bozmadan buraya ekliyorum.
        System.out.println("Dosya Okuma işlemi başarılı oldu");

        return  realService.read();
    }

    private boolean fileExists(String fileName) {
        return Files.exists(Paths.get(fileName));
    }
}

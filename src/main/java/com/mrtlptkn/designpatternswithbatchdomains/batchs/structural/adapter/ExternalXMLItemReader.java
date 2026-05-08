package com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.adapter;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


// bizim uygulamamız ise xml file okuyor ama dinamik olarak List<T> tipinde bir objeye dönüştürüyor.

public class ExternalXMLItemReader {
    public String readXMLFromSource(String filePath){
        return  "XML Data";
    }

}

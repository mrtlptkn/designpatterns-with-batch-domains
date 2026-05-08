package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory;

import java.util.List;

public interface IitemWriter<T> {
    void write(List<T> items);
}



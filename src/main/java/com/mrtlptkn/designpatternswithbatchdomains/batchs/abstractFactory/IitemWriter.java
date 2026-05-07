package com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory;

import java.util.List;

public interface IitemWriter<T> {
    void write(List<T> items);
}



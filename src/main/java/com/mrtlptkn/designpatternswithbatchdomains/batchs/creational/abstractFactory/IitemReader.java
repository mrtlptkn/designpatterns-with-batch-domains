package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory;

import java.util.List;

public interface IitemReader<T> {
    List<T> read();
}

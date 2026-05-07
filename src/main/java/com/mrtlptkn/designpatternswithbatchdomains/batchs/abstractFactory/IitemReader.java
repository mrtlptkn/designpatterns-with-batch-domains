package com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory;

import java.util.List;

public interface IitemReader<T> {
    List<T> read();
}

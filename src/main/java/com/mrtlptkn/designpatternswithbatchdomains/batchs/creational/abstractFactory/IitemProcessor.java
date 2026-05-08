package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory;

// Abstract Product
public interface IitemProcessor<T> {
    T process(T item);
}

// string -> uppercase,replace,split, numeric round, celing
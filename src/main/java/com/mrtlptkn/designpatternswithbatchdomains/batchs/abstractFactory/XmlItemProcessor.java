package com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory;


// CONCRETE PRODUCT
public class XmlItemProcessor<T> implements IitemProcessor<T> {
    @Override
    public T process(T item) {
        // Simulate XML processing logic
        System.out.println("Processing item as XML: " + item.toString());
        return item;
    }
}

package com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IitemReader<T> {
    List<T> read() throws ParserConfigurationException, IOException, SAXException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}

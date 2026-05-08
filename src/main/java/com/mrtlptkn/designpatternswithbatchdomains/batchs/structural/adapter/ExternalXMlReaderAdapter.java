package com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.adapter;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class User { private String firstName; }

// <users>
// <user>
// <firstName>Ali</firstName>
// <user>
// </users>



// Not: Proxy sınıfları ve Adapter sınıfları bir yapısal sorundan dolayı o ilgili sınıfa özgü yazılmış olan sınıflardır. O yüzden sorun teşkil eden sınıfla bir bağlantıları vardır.
public class ExternalXMlReaderAdapter<T> implements IitemReader<T> {


    private final ExternalXMLItemReader externalXMLItemReader;
    private final String filePath;
    private final Class<T> type;


    public ExternalXMlReaderAdapter(ExternalXMLItemReader externalXMLItemReader,String filePath,Class<T> type) {
        this.externalXMLItemReader = externalXMLItemReader;
        this.filePath = filePath;
        this.type = type;
    }

    @Override
    public List<T> read() throws ParserConfigurationException, IOException, SAXException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {


        String xmlData = this.externalXMLItemReader.readXMLFromSource(this.filePath);
        // convert to class
        // Reflection

        // XmlData alıp ramde bir döküman gibi okuyup listeye dönüştürüyoruz.
        // Kodu kendi kodumuza adapte ettiğimiz yer burası
        List<T> items = new ArrayList<>();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        InputSource is = new InputSource(new StringReader(xmlData));

        Document doc = db.parse(is);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName(xmlData); // <Users/> tag

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i); // <User>
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                T instance = type.getDeclaredConstructor().newInstance();
                Element element = (Element) node;
                for (Field field : type.getDeclaredFields()) { // <firstName />
                    field.setAccessible(true);
                    NodeList children = element.getElementsByTagName(field.getName());
                    if (children.getLength() > 0) {
                        String value = children.item(0).getTextContent();
                        if (field.getType() == String.class) {
                            field.set(instance, value);
                        } else if (field.getType() == int.class || field.getType() == Integer.class) {
                            field.set(instance, Integer.parseInt(value));
                        }
                    }
                }
                items.add(instance); // xml kaç adet alt node varsa ekler
            }
        }



        return items;
    }
}

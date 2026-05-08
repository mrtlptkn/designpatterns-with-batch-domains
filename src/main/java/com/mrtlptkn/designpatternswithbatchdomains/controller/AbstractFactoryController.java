package com.mrtlptkn.designpatternswithbatchdomains.controller;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.*;
import com.mrtlptkn.designpatternswithbatchdomains.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("api/abstractFactory")
public class AbstractFactoryController {


    @PostMapping("test")
    public String test() throws ParserConfigurationException, IOException, InvocationTargetException, SAXException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        // user.csv dosyasında okuma yaparken User.Class yazma işlemi yapıcam
        IBatchingProcessingFactory<User> userIBatchingProcessingFactory = new CsvBatchingProcessingFactory<>("user.csv", User.class);


        User usr = new User(1, "Ahmet", "Yılmaz","05555554422");

        // new CsvProcessing();
        // new CsvItemReader();
        // new CsvItemWriter();
        // new CsvItemProcessor();

        IitemReader<User> itemReader = userIBatchingProcessingFactory.createItemReader();
        IitemProcessor<User> itemProcessor = userIBatchingProcessingFactory.createItemProcessor();
        IitemWriter<User> itemWriter = userIBatchingProcessingFactory.createItemWriter();


        List<User> users =  itemReader.read();
        User processed =  itemProcessor.process(usr);
        itemWriter.write(users);


        IBatchingProcessingFactory<User> xmlIBatchingProcessingFactory = new XmlBatchingProcessingFactory<>("user.xml", User.class);
        User usr1 = new User(1, "Ahmet", "Yılmaz","05555554422");


        IitemReader<User> itemReader1 = xmlIBatchingProcessingFactory.createItemReader();
        IitemProcessor<User> itemProcessor1 = xmlIBatchingProcessingFactory.createItemProcessor();
        IitemWriter<User> itemWriter1 = xmlIBatchingProcessingFactory.createItemWriter();


        List<User> users1 =  itemReader1.read();
        User processed1 =  itemProcessor1.process(usr1);
        itemWriter1.write(users1);



        return "OK";
    }

}

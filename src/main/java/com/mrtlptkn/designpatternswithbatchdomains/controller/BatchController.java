package com.mrtlptkn.designpatternswithbatchdomains.controller;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemProcessor;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.decorator.StringFieldMaskDecorator;
import com.mrtlptkn.designpatternswithbatchdomains.models.User;
import com.mrtlptkn.designpatternswithbatchdomains.models.UserItemProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/batches")
public class BatchController {


    @PostMapping("decorator")
    public String decoratorTest() {

        User usr2 = new User(1," Ali", "taN","5465361626");

        // Genel Kanı -> Structural Pattern yapılarında -> Varolan koda dokunmadan, yeni bir sınıf ile
        // ilgili kodun yapısında bir değişiklik yapabilmek. (kontrol,adaptapte etme,yeni bir davranış kazandırma,erişimi tek bir arayüze indirgeme)
        UserItemProcessor userItemProcessor = new UserItemProcessor(); // base  -> decorator ana özellikleri buradan alır. uppercase,trim,lowercase
        StringFieldMaskDecorator<User> pipeline = new StringFieldMaskDecorator<>(userItemProcessor);

        pipeline.setFieldName("phoneNumber"); // hangi field için maskeleme yapıcaz.
        pipeline.setMaskedValue("XXX"); // maskeleme formatı bu  phoneNumber: +90 XXX-XXX-XX-XX
        pipeline.process(usr2);


        return "OK";
    }

}

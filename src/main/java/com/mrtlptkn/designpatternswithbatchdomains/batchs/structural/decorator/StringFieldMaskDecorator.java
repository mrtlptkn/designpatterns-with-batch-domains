package com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.decorator;


import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemProcessor;
import lombok.Setter;

import java.lang.reflect.Field;

// Process edilen nesnedeki String alanları alıp bunları belirli bir kurala göre maskeli olarak çalıştırmak
// Not: Proxy'e çok benzer bir yazım şekli olması sebebi ile bazen karıştırılabilir.
// Ama Proxy Pattern amaç, nesne erişimini kontrollü bir şekilde sağlamak, genel olarak yaygın kullanıldığı alanlar performans sorunlarına karşı bazı optimizasyonlar veya günvelik yetkilendirme gibi doğru erişim senaryoları kullanırız.
// Ama decoratorın amacı var olan nesnenin özzelliklerin farklı bir şekilde yapabilmesini geliştirebilmesini sağlamak.
// T tipindeki nesne process edilirken yeni bir özellik kazandırmak istiyoruz. Bazı belirli string alanlarda maskeli gösterme özelliği istiyoruz.
public class StringFieldMaskDecorator<T> extends ItemProcessorDecorator<T> {

    @Setter
    private String fieldName; // hangi fielda maskeleme yapılsın

    @Setter
    private String maskedValue = "***";


    public StringFieldMaskDecorator(IitemProcessor<T> decoratedProcessor) {
        super(decoratedProcessor);
    }


    @Override
    public T process(T item) {
        applyMask(item); // yeni bir özellik kazandı. bazı alanlar masked Text oldu.
        return super.process(item);
    }

    private void  applyMask(T item) {
        try{

            if(fieldName.isEmpty() || fieldName.isBlank())
                throw new UnsupportedOperationException("FieldName set etmelisiniz");

            Field field = item.getClass().getField(fieldName);
            field.setAccessible(true);

            if(field.getType() == String.class){ // maskeleme yapabilmek için string bir field olmalı
                String value = (String) field.get(item);
                if(value != null) {
                    // 3 karakterden sonrasını maskeli yap
                    String maskedText = value.length() > 3 ? value.substring(0,3) + maskedValue:maskedValue;
                    // propety güncel değeri set ettik.
                    field.set(item,maskedText);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

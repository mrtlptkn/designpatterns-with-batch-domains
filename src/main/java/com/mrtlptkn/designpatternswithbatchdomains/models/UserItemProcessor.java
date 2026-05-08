package com.mrtlptkn.designpatternswithbatchdomains.models;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemProcessor;

import java.util.Locale;

// Bir ETL sürecinde Processor sınıflar bir nesnenin alanlarının nasıl işleneceği konusu ile ilgilenir.
// trim, mask işlemleri, numericField, . veya , gibi programlama dillerden dillerine değişine alanlar, yuvarlama gibi senaryolar ile ilgilenir. Veri üzerinde belirli değişiklikler yapmak.

public class UserItemProcessor implements IitemProcessor<User> {
    @Override
    public User process(User item) {

        item.setFirstName(item.getFirstName().trim());
        item.setLastName(item.getLastName().toUpperCase(Locale.ROOT));
        item.setPhoneNumber("+90" + item.getPhoneNumber().trim());

        return item;
    }
}

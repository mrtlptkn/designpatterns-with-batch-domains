package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.observer;


// Ilan nesnesi bir eventin değişiminde bildirim gönderir.
// Takipde olanlar bu bildirimi alıcak.
// Bildirim fiyat değişiminde ilan sınıfından gönderilir.
public interface IlanObserver {

    void notify(PriceChangedEvent event);
}
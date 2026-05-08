package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.observer;


// Bildirim Takipcileridir.
// NotificationSubsciber olarak düşünülebilir.
public class AliSubscriber implements IlanObserver {

    @Override
    public void notify(PriceChangedEvent event) {

        // Git bunu favorilerinde behnemiş olan kişileri bul
        // Bunlar sahibinden.com uygulaması kullanıyorsa bunların telefonlarına bildirim at.
        System.out.println(
                "Ali -> Takip ettiğin ilan güncellendi. "
                        + "Yeni fiyat: "
                        + event.getNewPrice()
        );
    }
}
package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.observer;


// EmailSubscriber -> Fiyat değişimi olunca email atar.
// SlackSubsciber da olabilir. Başka bir tane
public class MertSubscriber implements IlanObserver {

    @Override
    public void notify(PriceChangedEvent event) {

        // Git bunu favorilerinde behnemiş olan kişileri bul bunların bildirim ayarlarında eğer email seçiliyse bunların e-posta adreslerine mail at.
        System.out.println(
                "Mert -> İlan fiyatı değişti. "
                        + "Eski fiyat: "
                        + event.getOldPrice()
                        + " Yeni fiyat: "
                        + event.getNewPrice()
        );
    }
}
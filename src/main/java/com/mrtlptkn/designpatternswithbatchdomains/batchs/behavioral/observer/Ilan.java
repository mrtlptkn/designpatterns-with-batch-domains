package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

// İlan üzerinde bir fiyat değişimi olunca bir bildirim gönderileceği için bu nesneye ihtiyaç
public class Ilan {

    private final int ilanId;

    private String title;

    private double price;

    // Observer listesi
    // EmailSubsciber, NotoificationSubsciber (Ali,Mert)
    private final List<IlanObserver> followers =
            new ArrayList<>();

    public Ilan(
            int ilanId,
            String title,
            double price
    ) {
        this.ilanId = ilanId;
        this.title = title;
        this.price = price;
    }

    // Takibe al
    public void subscribe(IlanObserver observer) {
        followers.add(observer);
    }

    // Takipten çık
    public void unsubscribe(IlanObserver observer) {
        followers.remove(observer);
    }

    // Notify
    private void notifyFollowers(
            PriceChangedEvent event
    ) {

        // bu fiyat değişimini takip eden tüm followlera bildirim gönder.
        for (IlanObserver observer : followers) {
            observer.notify(event);
        }
    }

    // PriceChanged
    public void changePrice(double newPrice) {

        double oldPrice = this.price;

        this.price = newPrice;

        System.out.println(
                "\nİlan fiyatı güncellendi : "
                        + oldPrice
                        + " -> "
                        + newPrice
        );

        // eventi hazırla bildirim gönder.
        PriceChangedEvent event =
                new PriceChangedEvent(
                        ilanId,
                        oldPrice,
                        newPrice
                );

        notifyFollowers(event);
    }
}
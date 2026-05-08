package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.observer;


// bu design pattern bir event tetiklendiğinde bilfirim göndermek için var.

public class PriceChangedEvent {

    private final int ilanId;

    private final double oldPrice;

    private final double newPrice;

    public PriceChangedEvent(
            int ilanId,
            double oldPrice,
            double newPrice
    ) {
        this.ilanId = ilanId;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public int getIlanId() {
        return ilanId;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }
}
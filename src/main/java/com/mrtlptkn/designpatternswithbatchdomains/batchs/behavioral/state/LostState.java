package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.state;


public class LostState implements OpportunityState {

    @Override
    public void startNegotiation(Opportunity opportunity) {
        throw new IllegalStateException(
                "Lost opportunity cannot go to negotiation"
        );
    }

    @Override
    public void win(Opportunity opportunity) {
        throw new IllegalStateException(
                "Lost opportunity cannot become won"
        );
    }

    @Override
    public void lose(Opportunity opportunity) {
        System.out.println("Already lost.");
    }

    @Override
    public String name() {
        return "LOST";
    }
}
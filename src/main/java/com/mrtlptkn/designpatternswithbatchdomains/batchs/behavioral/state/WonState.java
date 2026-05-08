package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.state;


public class WonState implements OpportunityState {

    @Override
    public void startNegotiation(Opportunity opportunity) {
        throw new IllegalStateException(
                "Won opportunity cannot go to negotiation"
        );
    }

    @Override
    public void win(Opportunity opportunity) {
        System.out.println("Already won.");
    }

    @Override
    public void lose(Opportunity opportunity) {
        throw new IllegalStateException(
                "Won opportunity cannot become lost"
        );
    }

    @Override
    public String name() {
        return "WON";
    }
}
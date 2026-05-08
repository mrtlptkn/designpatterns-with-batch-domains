package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.state;

public class NegotiationState implements OpportunityState {

    @Override
    public void startNegotiation(Opportunity opportunity) {
        System.out.println("Already in negotiation.");
    }

    @Override
    public void win(Opportunity opportunity) {
        System.out.println("Opportunity won.");
        opportunity.setState(new WonState());
    }

    @Override
    public void lose(Opportunity opportunity) {
        System.out.println("Opportunity lost.");
        opportunity.setState(new LostState());
    }

    @Override
    public String name() {
        return "NEGOTIATION";
    }
}

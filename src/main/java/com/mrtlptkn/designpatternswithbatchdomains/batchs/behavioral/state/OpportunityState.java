package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.state;


public interface OpportunityState {

    void startNegotiation(Opportunity opportunity);

    void win(Opportunity opportunity);

    void lose(Opportunity opportunity);

    String name();
}
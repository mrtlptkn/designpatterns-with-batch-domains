package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.state;

public class StateMain {
    public static void main(String[] args) {
        Opportunity opportunity = new Opportunity("asd");

        opportunity.printStatus();

        opportunity.startNegotiation();
        opportunity.printStatus();

        opportunity.win();
        opportunity.printStatus();

        // Hata fırlatır
        opportunity.lose();
    }
}

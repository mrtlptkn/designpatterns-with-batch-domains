package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.state;



public  class Opportunity {

    // State sınıf için field olarak kullanılıyor.
    private OpportunityState state;

    private String title;

    public Opportunity(String title) {
        this.title = title;
        this.state = new DraftState();
    }

    // state güncellem -> her bir akış sonrası state değişimi
    public void setState(OpportunityState state) {
        this.state = state;
    }

    // o anki güncel state
    public OpportunityState getState() {
        return state;
    }

    public String getTitle() {
        return title;
    }

    // Delegate methods

    public void startNegotiation() {
        state.startNegotiation(this);
    }

    public void win() {
        state.win(this);
    }

    public void lose() {
        state.lose(this);
    }

    public void printStatus() {
        System.out.println(
                "Opportunity: " + title +
                        " | Current State: " + state.name()
        );
    }
}
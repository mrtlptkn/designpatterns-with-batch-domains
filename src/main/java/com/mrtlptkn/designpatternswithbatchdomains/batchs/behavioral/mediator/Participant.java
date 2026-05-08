package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.mediator;

public abstract class Participant {

    protected ChatMediator mediator;

    protected String name;

    public Participant(
            ChatMediator mediator,
            String name
    ) {
        this.mediator = mediator;
        this.name = name;
    }

    // mesajı gönderme
    public abstract void send(String message);

    // mesajı alma
    public abstract void receive(String message);
}
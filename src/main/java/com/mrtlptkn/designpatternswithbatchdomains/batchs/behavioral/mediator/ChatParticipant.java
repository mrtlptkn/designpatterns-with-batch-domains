package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.mediator;

public class ChatParticipant extends Participant {

    public ChatParticipant(
            ChatMediator mediator, // indirect haberleşme için
            String name
    ) {
        super(mediator, name);
    }

    // ama mesajı odaya gönderiyor -> oda mesajı kişilere iletiyor
    @Override
    public void send(String message) {

        System.out.println(
                this.name + " gönderdi : " + message
        );

        mediator.sendMessage(message, this);
    }

    // mesajı alma -> odadan mesaj alınıyor
    @Override
    public void receive(String message) {

        System.out.println(
                this.name + " aldı : " + message
        );
    }
}
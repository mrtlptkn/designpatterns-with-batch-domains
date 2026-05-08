package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.mediator;

public interface ChatMediator {

    // odaya karılan herkese mesaj atmamızı sağlayan method
    void sendMessage(
            String message,
            Participant sender
    );

    // odaya katılımcı ekleme
    void addParticipant(Participant user);
}
package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.mediator;


import com.mrtlptkn.designpatternswithbatchdomains.models.User;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {

    private final List<Participant> participants =
            new ArrayList<>();

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    @Override
    public void sendMessage(
            String message,
            Participant sender
    ) {

        for (Participant participant : participants) {

            // Mesajı gönderen hariç herkese ilet
            if (participant != sender) {
                participant.receive(message);
            }
        }
    }
}
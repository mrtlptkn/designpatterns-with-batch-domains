package com.mrtlptkn.designpatternswithbatchdomains.controller;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.command.IStepCommand;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.command.RetryStepCommand;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.mediator.ChatMediator;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.mediator.ChatRoom;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.mediator.ChatParticipant;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.mediator.Participant;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.observer.AliSubscriber;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.observer.Ilan;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.observer.IlanObserver;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.observer.MertSubscriber;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.state.Opportunity;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.facade.BatchJobFacade;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.*;
import com.mrtlptkn.designpatternswithbatchdomains.models.JobRequest;
import com.mrtlptkn.designpatternswithbatchdomains.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/commands")
public class TestController {

    // Not: Bu kütüphaneyi kullanan bir geliştiricinin kompleks nesne oluşturma işlemleri ve süreçlerinden
    // izole olmasını sağladık. Facade bunu sağlar.
    private final BatchJobFacade jobFacade;

    public TestController(BatchJobFacade jobFacade){
        this.jobFacade = jobFacade;
    }

    @PostMapping("/facade")
    public String facade(@RequestBody JobRequest request) {
        JobExecution execution =  jobFacade.run(request);

        return "Builder Pattern executed successfully!";
    }

    @PostMapping("/command")
    public String command(@RequestBody JobRequest request) {

        // Örnek kullanım şekli
        IStepCommand stepCommand = new RetryStepCommand(5,new Step<User>("Step1"));
        stepCommand.execute(); // İlgili Step Nesnesini hata alırsa 5 defa execute etme özelliği gösteriyor.

        return "Builder Pattern executed successfully!";
    }


    // Not: Her state için bir süreç olduğundan dolayı burada tek tek post endpoint açılır.
    @PostMapping("/state")
    public String state() {

        Opportunity opportunity = new Opportunity("asd");

        opportunity.printStatus();

        opportunity.startNegotiation();
        opportunity.printStatus();

        opportunity.win();
        opportunity.printStatus();

        // Hata fırlatır
        opportunity.lose();

        return "Builder Pattern executed successfully!";
    }

    @PostMapping("observer")
    public String observer() {
        Ilan ilan =
                new Ilan(
                        1,
                        "Sahibinden BMW",
                        950000
                );

        // Subscribers
        IlanObserver mert =
                new MertSubscriber();

        IlanObserver ali =
                new AliSubscriber();


        // Takibe al
        ilan.subscribe(mert);
        ilan.subscribe(ali);

        // Fiyat değiştir
        ilan.changePrice(920000);

        ilan.changePrice(890000);

        return "OK";
    }

    @PostMapping("mediator")
    public String mediator(){

        // chat odası -> mesajlaşma yönetimi
        ChatMediator mediator =
                new ChatRoom();

        // odaya kayıt olan kişiler
        Participant ahmet =
                new ChatParticipant(mediator, "Ahmet");

        Participant mert =
                new ChatParticipant(mediator, "Mert");

        Participant ali =
                new ChatParticipant(mediator, "Ali");

        // odaya giriş
        mediator.addParticipant(ahmet);
        mediator.addParticipant(mert);
        mediator.addParticipant(ali);

        // amaç birbirleri heberleşme ama bunu mediator üzerinden yapacaklar
        ahmet.send("Merhaba arkadaşlar");

        System.out.println();

        mert.send("Selam Ahmet");

        return  "OK";
    }



}

package com.mrtlptkn.designpatternswithbatchdomains.controller;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.command.IStepCommand;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.command.RetryStepCommand;
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




}

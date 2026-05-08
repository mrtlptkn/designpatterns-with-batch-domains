package com.mrtlptkn.designpatternswithbatchdomains.controller;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.*;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.factoryMethod.JobType;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.factoryMethod.JobFactory;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.builder.JobBuilder;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.builder.StepBuilder;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.singleton.JobLauncher;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.facade.BatchJobFacade;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.proxy.CsvItemReaderProxy;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.*;
import com.mrtlptkn.designpatternswithbatchdomains.models.JobRequest;
import com.mrtlptkn.designpatternswithbatchdomains.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/builders")
public class BuilderController {

    // Not: Bu kütüphaneyi kullanan bir geliştiricinin kompleks nesne oluşturma işlemleri ve süreçlerinden
    // izole olmasını sağladık. Facade bunu sağlar.
    private final BatchJobFacade jobFacade;

    public BuilderController(BatchJobFacade jobFacade){
        this.jobFacade = jobFacade;
    }

    @PostMapping("/test")
    public String test(@RequestBody JobRequest request) {

        JobExecution execution =  jobFacade.run(request);

        return "Builder Pattern executed successfully!";
    }
}

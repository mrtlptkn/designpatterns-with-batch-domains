package com.mrtlptkn.designpatternswithbatchdomains.controller;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.abstractFactory.*;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.builders.IJobBuilder;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.builders.IStepBuilder;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.builders.JobBuilder;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.builders.StepBuilder;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.*;
import com.mrtlptkn.designpatternswithbatchdomains.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/builders")
public class BuilderController {

    @PostMapping("/test")
    public String executeBuilderPattern() {
        // Builder Pattern örneği burada oluşturulacak ve çalıştırılacak.

        // Normal Object Oriented kod yazım şekli
        Step step1 = new Step("Step1");
        Step step2 = new Step("Step2");




        Job jb = new Job("Job1");
        jb.addStep(step1);
        jb.addStep(step2);

        JobParameters jobParameters = new JobParameters(jb.getId());
        jobParameters.addParameter("date", "2024-01-01");
        jobParameters.addParameter("env", "prod");

        jb.execute(jobParameters);



        // ------------------------------------ WITH BUILDER PATTERN ------------------------------------

        JobParameters jobParameters2 = new JobParameters(jb.getId());
        jobParameters2.addParameter("date", "2024-01-01");
        jobParameters2.addParameter("env", "prod");

        // Senaryo 1
        IitemReader<User> userIitemReader = new XmlItemReader<>("user.xml", User.class);
        // bu dosyadan oku
        IitemProcessor<User> userIitemProcessor = new XmlItemProcessor<>();
        // işle
        IitemWriter<User> userIitemWriter = new XMLItemWriter<>("user-new.xml");
        // yaz

        IStep step3 = new StepBuilder<User>("Step3")
                .withReader(userIitemReader)
                .withProcessor(userIitemProcessor)
                .withWriter(userIitemWriter)
                .build();


        // Senaryo 2 -> CSV okur -> CSV den okunan process eder -> Users.XML dosyasına yaz.
        IitemReader<User> csvUserItemReader = new CsvItemReader<>("users.csv", User.class);
        IitemProcessor<User> csvUserItemProcessor = new CSVItemProcessor<>();
        IitemWriter<User> xmlUserItemWriter = new XMLItemWriter<>(  "users.xml");

        IStep step4 = new StepBuilder<User>("Step4")
                .withReader(csvUserItemReader)
                .withProcessor(csvUserItemProcessor)
                .withWriter(xmlUserItemWriter)
                .build();

        IJob job2 = new JobBuilder("Job1")
                .start(step3)
                .next(step4)
                .build();

        job2.execute(jobParameters2);


        return "Builder Pattern executed successfully!";
    }
}

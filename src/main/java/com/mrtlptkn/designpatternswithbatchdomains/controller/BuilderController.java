package com.mrtlptkn.designpatternswithbatchdomains.controller;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.*;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.factoryMethod.JobType;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.factoryMethod.JobFactory;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.builder.JobBuilder;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.builder.StepBuilder;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.singleton.JobLauncher;
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



        SimpleJob jb = new SimpleJob("Job1");
        jb.addStep(step1);
        jb.addStep(step2);

        JobParameters jobParameters = new JobParameters(jb.getId());
        jobParameters.addParameter("date", "2024-01-01");
        jobParameters.addParameter("env", "prod");

//        jb.execute(jobParameters);


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

        // Csv de bi hata var ? Neden ?
        IStep step4 = new StepBuilder<User>("Step4")
                .withReader(csvUserItemReader)
                .withProcessor(csvUserItemProcessor)
                .withWriter(xmlUserItemWriter)
                .build();


        // Gramer açısından Daha kullanışlı bir yöntem.
        IJob job2 = new JobBuilder("Job1",JobType.Simple)
                .start(step3)
                .next(step4)
                .build();

        JobLauncher.getInstance().run(job2, jobParameters2);
        //job2.execute(jobParameters2); Bunun yerine JobLauncher tercih edeceğiz.


        // Factory Method
//        IJob job3 = new StandartJobFactory("SimpleJob").createJob("Job3");
//        IJob job4 = new StandartJobFactory("Autonomous").createJob("Job4");

        // aşağıdaki genel olarak daha kullanışsız bir yöntem.
       IJob jb4 =  JobFactory.createJob(JobType.Simple, "Job3");
       jb4.addStep(step3);
       jb4.addStep(step4);
       jb4.execute(jobParameters2);

        JobFactory.createJob(JobType.Autonomous, "Job4").execute(jobParameters2);



        return "Builder Pattern executed successfully!";
    }
}

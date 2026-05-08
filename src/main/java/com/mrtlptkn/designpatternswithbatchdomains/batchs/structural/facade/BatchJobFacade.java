package com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.facade;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.*;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.builder.IJobBuilder;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.builder.JobBuilder;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.builder.StepBuilder;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.factoryMethod.JobType;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.singleton.JobLauncher;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.adapter.ExternalXMLItemReader;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.adapter.ExternalXMlReaderAdapter;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.structural.proxy.CsvItemReaderProxy;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IJob;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IStep;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.JobExecution;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.JobParameters;
import com.mrtlptkn.designpatternswithbatchdomains.models.JobRequest;
import com.mrtlptkn.designpatternswithbatchdomains.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static tools.jackson.databind.type.LogicalType.Map;

@Component
public class BatchJobFacade {

    // Not: Farklı servislerde olabilir onlarda facade orayüzünü dpenecy injection yada dependecy inversion ile bağlanırlar.
    // Sorun bu -> Her job çalıştırma işleminde aşağıdaki kodu defalarca kez uygulama içerisinde yazmak lazım.


    public JobExecution run(JobRequest request) {


        IJobBuilder jobBuilder = new JobBuilder(request.jobName(), JobType.Simple);

        request.steps().forEach(item -> {


            if (item.type().equals("csv")) {
                IitemReader<User> itemReader = new CsvItemReader<>("data.csv", User.class);
                IitemProcessor<User> itemProcessor = new CSVItemProcessor<>();
                IitemWriter<User> itemWriter = new CsvItemWriter<>("data-result.csv");

                IStep step = new StepBuilder<User>(item.stepName())
                        .withReader(itemReader)
                        .withProcessor(itemProcessor)
                        .withWriter(itemWriter)
                        .build();

                jobBuilder.next(step);
            } else if (item.type().equals("xml")) {




//                IitemReader<User> itemReader = new XmlItemReader<>("data.xml", User.class);

                // Senaryo: Bizim sistemde xmlreader da sorun vardı. Başka bir kütüphanden yararlanmak istedik.
                // Bu durumda küphanedeki kodda bize uyum sağlamıyor
                // Ne yapacağız ? Adapter pattern ile library kodu kendi sistemimiz bozmandan adapte edeceğiz.
                ExternalXMLItemReader externalXMLItemReader = new ExternalXMLItemReader();
                // Libraryden gelen bizim yazmadığımız referans olarak kullanmak istediğimiz kod

                IitemReader<User> itemReader = new ExternalXMlReaderAdapter<>(externalXMLItemReader,"data.xml", User.class);
                // Uygulamada library üzerinden kullnacağımız bizim yazdığımız ara kod.
                // Anti corruption layer. -> Buna biz bozulma önleyici katman
                // Yolsuzluk Önleme Katmanı, Bozulma Önleyici Katman

                // Adapter'ı araya koydu eski librayden okuyacak şekilde ama bizim formatımıza çevirek şekilde kodu adapte ettik.



                IitemProcessor<User> itemProcessor = new XmlItemProcessor<>();
                IitemWriter<User> itemWriter = new XMLItemWriter<>("data-result.xml");

                IStep step = new StepBuilder<User>(item.stepName())
                        .withReader(itemReader)
                        .withProcessor(itemProcessor)
                        .withWriter(itemWriter)
                        .withRetry(5) // RetryCommand uygulayabilir oldu.
                        .build();

                jobBuilder.next(step);
            } else {
                throw new UnsupportedOperationException("Desteklenen bir tip değil");
            }

        });

        IJob job = jobBuilder.build();

        JobParameters jobParameters = new JobParameters(job.getId());
        request.params().forEach(jobParameters::addParameter);

        return JobLauncher.getInstance().run(job, jobParameters);

    }

}

package com.mrtlptkn.designpatternswithbatchdomains.jobs;

import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemProcessor;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemReader;
import com.mrtlptkn.designpatternswithbatchdomains.batchs.creational.abstractFactory.IitemWriter;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// execute methodunda yapılan önce read sonra process en son write yapar Bu sebeple bir bir template yapısı üzerinden execute kodunun çalışmasını sağlıyoruz ama sadece tek bir step üzerinde çalıştığımız için tam olarak bir template Method tasarım deseni yaptığımız söylenemez.
// -> Behaviors -> Template Method bakabiliriz.

public class Step<T> implements IStep {

    @Getter
    private final String id;

    @Getter
    private final String stepName;

    @Setter
    private IitemReader<T> reader;

    @Setter
    private IitemWriter<T> writer;

    @Setter
    private IitemProcessor<T> processor;

    public Step(String stepName) {
        this.id = UUID.randomUUID().toString();
        this.stepName = stepName;
    }


    @Override
    public StepExecution execute() {
        StepExecution stepExecution = new StepExecution(this);

        // read, write, process süreçleri eksik.
        try {
            System.out.println("Executing step: " + stepName);

            // template süreci
            // Bir şey bir kaynaktan okunmadan process edilemez o yüzden process için
            // okunan bir veri olması lazım. Aynı zamanda bir şeyi bir dosyaya yazmak için okunmuş olması gerekir
            if(reader != null) {
                List<T> data = reader.read();
                System.out.println("Dosya okundu");
//
//                if(processor != null) {
//                    data.replaceAll(item -> processor.process(item));
//                    System.out.println("Dosya İşlendi");
//                }

                if(writer != null) {
                    writer.write(data);
                    System.out.println("Dosya Yazıldı");
                }

                stepExecution.setStatus(BatchStatus.Completed);
            }
            else {
             throw new IllegalStateException("Reader olmadan süreç başlatılamaz");
            }

        } catch (Exception e) {
            System.out.println("Error executing step: " + stepName);
            stepExecution.setStatus(BatchStatus.Failed);
            throw new RuntimeException(e);
        }

        System.out.println("Step '" + stepName + "' execution completed with status: " + stepExecution.getStatus());

        return stepExecution;

    }


}

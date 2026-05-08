package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.command;

import com.mrtlptkn.designpatternswithbatchdomains.jobs.BatchStatus;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.IStep;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.StepExecution;


// CancelStepCommand, SkipStepCommand (Step atlatma işlemleri)

public class RetryStepCommand implements IStepCommand {

    private  final  int maxRetries;
    private int currentRetry = 0;
    private IStep step;

    public RetryStepCommand(int maxRetries,IStep step){

        this.maxRetries = maxRetries;
        this.step = step;
    }

    // Sorumlulu alan sınıf belirli bir davranış logic uygular.

    @Override
    public void execute() {
        boolean success = false;
        do {

            try {

                StepExecution execution = step.execute();
                success = true;
                System.out.println("İşlem başarılı");

            } catch (RuntimeException e) {
                currentRetry++;

                System.out.println(
                        "Hata oluştu. Deneme sayısı: "
                                + currentRetry);
                if (currentRetry < maxRetries) {
                    System.out.println("Tekrar deneniyor...");
                } else {
                    System.out.println("Max retry sayısına ulaşıldı");
                }
            }

        } while (!success && currentRetry < maxRetries);

    }
}

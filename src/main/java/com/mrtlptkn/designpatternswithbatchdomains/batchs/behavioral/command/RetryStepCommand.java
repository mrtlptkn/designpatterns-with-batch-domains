package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.command;

import com.mrtlptkn.designpatternswithbatchdomains.jobs.BatchStatus;
import com.mrtlptkn.designpatternswithbatchdomains.jobs.StepExecution;


// CancelStepCommand, SkipStepCommand (Step atlatma işlemleri)

public class RetryStepCommand implements IStepCommand {

    private  final  int maxRetries;
    private int currentRetry = 0;

    public RetryStepCommand(int maxRetries){
        this.maxRetries = maxRetries;
    }

    // Sorumlulu alan sınıf belirli bir davranış logic uygular.

    @Override
    public void execute(StepExecution stepExecution) {

        while (currentRetry < maxRetries){
            try {

                if(currentRetry > 0) {
                    System.out.println("Tekrar deneme algoritması");
                    stepExecution.setStatus(BatchStatus.Retry);
                }

            } catch (RuntimeException e) {
                currentRetry++;
                System.out.println("Kaç kez denendi " + 3);
               if(currentRetry >= maxRetries) { // 3 limiti varmış aşmış artık hata olarak yakaladık işaretledik.
                   stepExecution.setStatus(BatchStatus.Failed);
               }
            }
        }

        stepExecution.setStatus(BatchStatus.Completed);

    }
}

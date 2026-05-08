package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.command;

import com.mrtlptkn.designpatternswithbatchdomains.jobs.StepExecution;

// steplerin hata durumunda atlatılabilir veya yenşden denebilir olmasını istiyoruz.

public interface IStepCommand {
    void execute(); // bir davranış hesaplama, bir kod bloğu çalıştırma, bir akış içerisine bir komut eklemek, bir davranış eklemek için kullanıyoruz.
    // Behavior ile Structual arasında en teml fark behavior patternler bu davranışı ilgili sınıfa kazandırmalı.
    // Behaviorda yapısal bir değişiklik var kod düzeyinde.
    // Çok Önemli: Behavior tasarım desenlerinde genel amaç davranışı -> başka bir sınıfın sorumluluğuna bırakmaktır. Step hata durumunda yeniden çalıştırılsın davranışını biz RetryCommand sınıfına verdik.
}

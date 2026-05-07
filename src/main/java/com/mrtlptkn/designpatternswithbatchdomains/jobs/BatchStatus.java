package com.mrtlptkn.designpatternswithbatchdomains.jobs;

// Bu yapımızda 2 tane tasarım deseninden yararlanıldı 1. Composite Pattern, 2. Template Method Pattern
// Job yada Step kesintiler veya tamamlanma işllmeleri bu status üzerinden takip edilebilir. Bu sayede Job ve Step'lerin durumlarını yönetmek ve izlemek daha kolay hale gelir.
public enum BatchStatus {
    Started,
    Completed,
    Failed
}

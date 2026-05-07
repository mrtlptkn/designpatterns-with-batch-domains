package com.mrtlptkn.designpatternswithbatchdomains.jobs;

// key, value cinsinden değerler vardı -> jobCode -> JB-234324, startAt -> 07.05.2026, -> createdBy -> Ali, departmentId: 3242344551sad

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// Jobın hangi parametreler ile çalıştırığı bilgisini tutar
public class JobParameters {

    @Getter
    private final String id;

    @Getter
    private final String jobId; // hangi job id için bu parametre girildi

    public JobParameters(String jobId) {
        this.jobId = jobId;
        this.id = UUID.randomUUID().toString(); // Her parametre seti için benzersiz bir id oluşturulur
    }


    private final Map<String,String> parameters = new HashMap<>();

    public void addParameter(String key, String value) {
        parameters.put(key, value);
    }


    public String getParameterValue(String key) {
        return parameters.get(key);
    }

    public Map<String, String> getAllParameters() {
        // Parametre Objesi olur.
        return parameters;
    }


}

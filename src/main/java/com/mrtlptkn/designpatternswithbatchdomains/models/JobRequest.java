package com.mrtlptkn.designpatternswithbatchdomains.models;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// type -> csv, xml


public record JobRequest(String jobName, Map<String,String> params, List<StepRequest> steps) {

}

package com.mrtlptkn.designpatternswithbatchdomains.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}

package com.example.lab4.Model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class Address {

    private String street;
    private Long zip;
    private String city;

}

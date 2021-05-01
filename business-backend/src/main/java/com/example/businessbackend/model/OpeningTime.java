package com.example.businessbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OpeningTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String openingHour;
    private String closingHour;

    public OpeningTime(String openingHour, String closingHour) {
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }
}

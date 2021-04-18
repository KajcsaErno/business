package com.example.businessbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OpeningHoursDTO {

    private String dayOfWeek;
    private String openingHours;
}

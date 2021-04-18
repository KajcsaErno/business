package com.example.businessbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WorkingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DayOfWeek dayOfWeek;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OpeningTime> openingTimes = new ArrayList<>();

    public WorkingDay(DayOfWeek dayOfWeek, List<OpeningTime> openingTimes) {
        this.dayOfWeek = dayOfWeek;
        this.openingTimes = openingTimes;
    }
}





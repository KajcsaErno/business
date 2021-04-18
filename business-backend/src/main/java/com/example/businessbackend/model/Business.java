package com.example.businessbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<WorkingDay> workingDayList = new ArrayList<>();

    public void addOpeningHour(WorkingDay workingDay) {
        workingDayList.add(workingDay);
    }
}

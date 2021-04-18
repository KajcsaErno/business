package com.example.businessbackend;

import com.example.businessbackend.dto.BusinessDTO;
import com.example.businessbackend.dto.adapter.BusinessAdapter;
import com.example.businessbackend.model.Business;
import com.example.businessbackend.model.BusinessRepository;
import com.example.businessbackend.model.OpeningTime;
import com.example.businessbackend.model.WorkingDay;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BusinessBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BusinessRepository businessRepository) {
        return args -> {
            BusinessAdapter businessAdapter = new BusinessAdapter();

            Business leCafe = new Business();
            leCafe.setName("Le Cafe du Marche");
            leCafe.setAddress("Rue de Conthey 17, 1950 Sion, Switzerland");
            setOpeningTimes(leCafe, DayOfWeek.MONDAY, "closed", "closed");
            setOpeningTimesWithTwoTimes(leCafe, DayOfWeek.TUESDAY, "11:30", "15:00", "18:30", "00:00");
            setOpeningTimesWithTwoTimes(leCafe, DayOfWeek.WEDNESDAY, "11:30", "15:00", "18:30", "00:00");
            setOpeningTimesWithTwoTimes(leCafe, DayOfWeek.THURSDAY, "11:30", "15:00", "18:30", "00:00");
            setOpeningTimesWithTwoTimes(leCafe, DayOfWeek.FRIDAY, "11:30", "15:00", "18:30", "00:00");
            setOpeningTimes(leCafe, DayOfWeek.SATURDAY, "18:00", "00:00");
            setOpeningTimes(leCafe, DayOfWeek.SUNDAY, "11:30", "15:00");
            BusinessDTO leCafeBusinessDTO = businessAdapter.toDTO(leCafe);

            Business pizzaBella = new Business();
            pizzaBella.setName("Pizza Bella");
            pizzaBella.setAddress("Bulevardul Brașovului 76, Săcele 505600, Romania");
            setOpeningTimes(pizzaBella, DayOfWeek.MONDAY, "closed", "closed");
            setOpeningTimes(pizzaBella, DayOfWeek.TUESDAY, "12:00", "00:00");
            setOpeningTimesWithTwoTimes(pizzaBella, DayOfWeek.WEDNESDAY, "8:30", "14:00", "16:30", "23:00");
            setOpeningTimesWithTwoTimes(pizzaBella, DayOfWeek.THURSDAY, "8:30", "14:00", "16:30", "23:00");
            setOpeningTimes(pizzaBella, DayOfWeek.FRIDAY, "closed", "closed");
            setOpeningTimes(pizzaBella, DayOfWeek.SATURDAY, "12:00", "00:00");
            setOpeningTimes(pizzaBella, DayOfWeek.SUNDAY, "12:00", "00:00");
            BusinessDTO pizzaBellaBusinessDTO = businessAdapter.toDTO(pizzaBella);

            Business selmasHairport = new Business();
            selmasHairport.setName("Selma`s Hairport");
            selmasHairport.setAddress("Hauptstraße 63, 71093 Weil im Schönbuch, Germany");
            setOpeningTimes(selmasHairport, DayOfWeek.MONDAY, "8:00", "16:30");
            setOpeningTimes(selmasHairport, DayOfWeek.TUESDAY, "8:00", "16:30");
            setOpeningTimes(selmasHairport, DayOfWeek.WEDNESDAY, "8:00", "16:30");
            setOpeningTimes(selmasHairport, DayOfWeek.THURSDAY, "8:00", "16:30");
            setOpeningTimes(selmasHairport, DayOfWeek.FRIDAY, "8:00", "16:30");
            setOpeningTimes(selmasHairport, DayOfWeek.SATURDAY, "8:00", "13:30");
            setOpeningTimes(selmasHairport, DayOfWeek.SUNDAY, "closed", "closed");
            BusinessDTO selmasHairportBusinessDTO = businessAdapter.toDTO(selmasHairport);

            List<Business> businessList = new ArrayList<>();
            businessList.add(leCafe);
            businessList.add(pizzaBella);
            businessList.add(selmasHairport);
            businessList.forEach(businessRepository::save);

        };
    }

    private void setOpeningTimes(Business business, DayOfWeek dayOfWeek, String openingTime, String closingTime) {
        OpeningTime firstOpeningTime = new OpeningTime(openingTime, closingTime);

        List<OpeningTime> openingTimesList = new ArrayList<>();
        openingTimesList.add(firstOpeningTime);

        business.addOpeningHour(new WorkingDay(dayOfWeek, openingTimesList));
    }

    private void setOpeningTimesWithTwoTimes(Business business, DayOfWeek dayOfWeek, String openingTime1, String closingTime1, String openingTime2, String closingTime2) {
        OpeningTime firstOpeningTime = new OpeningTime(openingTime1, closingTime1);
        OpeningTime secondOpeningTime = new OpeningTime(openingTime2, closingTime2);

        List<OpeningTime> openingTimesList = new ArrayList<>();
        openingTimesList.add(firstOpeningTime);
        openingTimesList.add(secondOpeningTime);

        business.addOpeningHour(new WorkingDay(dayOfWeek, openingTimesList));
    }

}

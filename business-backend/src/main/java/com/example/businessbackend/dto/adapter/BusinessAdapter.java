package com.example.businessbackend.dto.adapter;

import com.example.businessbackend.dto.BusinessDTO;
import com.example.businessbackend.dto.OpeningHoursDTO;
import com.example.businessbackend.model.Business;
import com.example.businessbackend.model.OpeningTime;
import com.example.businessbackend.model.WorkingDay;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.*;

@Getter
@Setter
@Component
public class BusinessAdapter {
    private OpeningTime openingTime;

    public BusinessDTO toDTO(Business business) {
        BusinessDTO businessDTO = new BusinessDTO();
        businessDTO.setName(business.getName());
        businessDTO.setAddress(business.getAddress());

        Map<String, List<DayOfWeek>> dayOfWeekMap = new HashMap<>();

        for (WorkingDay workingDay : business.getWorkingDayList()) {
            for (OpeningTime openingTime2 : workingDay.getOpeningTimes()) {

                if (dayOfWeekMap.containsKey(getComposedKey(openingTime2))) {
                    dayOfWeekMap.get(getComposedKey(openingTime2)).add(workingDay.getDayOfWeek());
                } else {
                    List<DayOfWeek> dayOfWeekList = new ArrayList<>();
                    dayOfWeekList.add(workingDay.getDayOfWeek());
                    dayOfWeekMap.put(getComposedKey(openingTime2), dayOfWeekList);
                }
            }

        }

        List<OpeningHoursDTO> openingHoursDTOList = new ArrayList<>();
        dayOfWeekMap.forEach((k, v) -> {
            Collections.sort(v);

            OpeningHoursDTO openingHoursDTO = new OpeningHoursDTO();
            if (v.size() > 1) {
                String startDay = v.get(0).toString();
                String lastDay = v.get(v.size() - 1).toString();

                openingHoursDTO.setDayOfWeek(startDay + " - " + lastDay);
                openingHoursDTO.setOpeningHours(k);

            } else {
                openingHoursDTO.setDayOfWeek(v.get(0).toString());
                openingHoursDTO.setOpeningHours(k);
            }
            openingHoursDTOList.add(openingHoursDTO);
//            v.forEach( days -> {
//                System.out.println("days = " + days);
//            });
        });

        businessDTO.setOpeningHoursDTO(openingHoursDTOList);
        System.out.println("dayOfWeekMap = " + dayOfWeekMap);
        return businessDTO;
    }


    public String getComposedKey(OpeningTime openingTime) {
        if ("closed".equals(openingTime.getOpeningTime())) {
            return "closed";
        }
        return openingTime.getOpeningTime() + " - " + openingTime.getClosingTime();

    }


}

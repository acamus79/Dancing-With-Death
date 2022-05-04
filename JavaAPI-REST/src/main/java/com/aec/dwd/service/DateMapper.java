package com.aec.dwd.service;

import com.aec.dwd.model.DateEntity;
import com.aec.dwd.model.DateDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Component
public class DateMapper {
    
    public DateEntity dto2Entity(DateDTO dto) {
        DateEntity date = new DateEntity();
        date.setDancingDate(this.string2LocalDate(dto.getDancingDate()));
        date.setDancingTime(this.string2LocalTime(dto.getDancingTime()));
        date.setEmail(dto.getEmail());
        date.setName(dto.getName());
        return date;
    }

    public DateDTO entity2DTO(DateEntity date) {
        DateDTO dto = new DateDTO();
        dto.setId(date.getId());
        dto.setEmail(date.getEmail());
        dto.setName(date.getName());
        dto.setDancingDate(this.localDate2String(date.getDancingDate()));
        dto.setDancingTime(this.localTime2String(date.getDancingTime()));
        return dto;
    }
    
    public List<DateDTO> entityList2DtoList(List<DateEntity> dateList) {
        List<DateDTO> dtos = new ArrayList<>();
        
        dateList.forEach(entity -> {
            dtos.add(this.entity2DTO(entity));
        });
        return dtos;
    }
     
    /**
     *
     * @param dateString
     * @return LocalDate
     */
    public LocalDate string2LocalDate(String dateString) {
        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateString, dtm);
        return date;
    }

    /**
     *
     * @param date
     * @return String
     */
    public String localDate2String(LocalDate date) {
        String stringDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return stringDate;
    }

    public LocalTime string2LocalTime(String timeString){
        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(timeString, dtm);
    }
    
    public String localTime2String(LocalTime time){
        String stringTime = time.format(DateTimeFormatter.ofPattern("HH:mm"));
        return stringTime;
    }
    
}

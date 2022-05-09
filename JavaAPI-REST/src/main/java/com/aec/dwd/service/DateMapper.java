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
 * @author Adrian E. Camus
 */
@Component
public class DateMapper {
    
    /**
     * Receives a data transfer object, creates an entity that is born active 
     * autogenerates an ID, and assigns the remaining values ​​that it takes 
     * from the DTO, returning this entity.
     * @param dto
     * @return entity
     */
    public DateEntity dto2Entity(DateDTO dto) {
        DateEntity date = new DateEntity();
        date.setDancingDate(this.string2LocalDate(dto.getDancingDate()));
        date.setDancingTime(this.string2LocalTime(dto.getDancingTime()));
        date.setEmail(dto.getEmail());
        date.setName(dto.getName());
        return date;
    }
    
    /**
     * Receives an entity, creates a data transfer object and fills it with
     * the entity's attributes and returns this DTO
     * @param date
     * @return DTO
     */
    public DateDTO entity2DTO(DateEntity date) {
        DateDTO dto = new DateDTO();
        dto.setId(date.getId());
        dto.setEmail(date.getEmail());
        dto.setName(date.getName());
        dto.setDancingDate(this.localDate2String(date.getDancingDate()));
        dto.setDancingTime(this.localTime2String(date.getDancingTime()));
        return dto;
    }
    
    /**
     * Receives a list of entities, creates a list of transfer objects which 
     * it populates by looping through the list of entities 
     * transforming each into a DTO
     * @param dateList
     * @return List(DTO)
     */
    public List<DateDTO> entityList2DtoList(List<DateEntity> dateList) {
        List<DateDTO> dtos = new ArrayList<>();
        
        dateList.forEach(entity -> {
            dtos.add(this.entity2DTO(entity));
        });
        return dtos;
    }
     
    /**
     * LocalDate to String
     * Format dd/MM/yyyy
     * @param dateString
     * @return LocalDate
     */
    public LocalDate string2LocalDate(String dateString) {
        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateString, dtm);
        return date;
    }

    /**
     * String to LocalDate Object, format dd/MM/yyyy
     * @param date
     * @return String
     */
    public String localDate2String(LocalDate date) {
        String stringDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return stringDate;
    }
    
    /**
     * String to Local Time Object, Format HH:mm
     * @param timeString
     * @return 
     */
    public LocalTime string2LocalTime(String timeString){
        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(timeString, dtm);
    }
    
    /**
     * LocalTime to String
     * @param time
     * @return 
     */
    public String localTime2String(LocalTime time){
        String stringTime = time.format(DateTimeFormatter.ofPattern("HH:mm"));
        return stringTime;
    }
    
}

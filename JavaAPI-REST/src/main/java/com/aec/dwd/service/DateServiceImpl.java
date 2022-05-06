package com.aec.dwd.service;

import com.aec.dwd.exception.ParamNotFound;
import com.aec.dwd.model.DateEntity;
import com.aec.dwd.model.DateDTO;
import com.aec.dwd.repositories.DateRepository;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Service
public class DateServiceImpl implements DateService{
    
    @Autowired
    DateRepository dRepo;
    
    @Autowired
    DateMapper dMapper;
   
    @Override
    public DateDTO save(DateDTO dto) {
        DateDTO dtoResult = this.verifyDTO(dto);
        
        if(dto.getId()== null){
            DateEntity entity = dRepo.save(dMapper.dto2Entity(dto));
            return dMapper.entity2DTO(entity);
        }
        return dtoResult;    
    }

    @Override
    public List<DateDTO> getAll() {
        List<DateEntity> entities = dRepo.searchActive();
        List<DateDTO> result = dMapper.entityList2DtoList(entities);
        return result;
    }

    @Override
    public DateDTO update(DateDTO dto) {
        DateEntity date = this.findById(dto.getId());
        date.setEmail(dto.getEmail());
        date.setName(dto.getName());
        dRepo.save(date);
        return dMapper.entity2DTO(date);
    }

    @Override
    public void delete(String id) {
        dRepo.delete(this.findById(id));
    }

    @Override
    public DateDTO getDetails(String id) {
        return dMapper.entity2DTO(this.findById(id));
    }
        
    @Override
    public List<DateDTO> getDate(DateDTO day) {
        
        List<DateEntity> schedule = dRepo.findAll();
        List<DateEntity> thisDay = new ArrayList();
        
        for (DateEntity dateEntity : schedule) {
            if(dMapper.localDate2String(dateEntity.getDancingDate()).equals(day.getDancingDate())){
                thisDay.add(dateEntity);
            }
        }
        return dMapper.entityList2DtoList(thisDay);
    }
    
    //**********************/ METODOS PRIVADOS /**********************
    
    /**
     * Recibe un String y devuelve una Entidad si existe
     * @param id
     * @return DateEntity
     */
    private DateEntity findById(String id) {
        Optional<DateEntity> op = dRepo.findById(id);
        
        if (!op.isPresent()){
            throw new ParamNotFound("No Date for id: " + id);
        }else if(!op.get().isActive()){
            throw new ParamNotFound("No Date active for id: " + id);
        }
        return op.get();
    }
    
    /**
     * Verificacion de Horario de 9:00 a 17:00 hs.
     * Verificacion de dias de la semana
     * Verificacion de Email no repetido en el dia.
     * @param dto
     * @return 
     */
    private DateDTO verifyDTO(DateDTO dto){
        LocalTime moment = dMapper.string2LocalTime(dto.getDancingTime());
        LocalDate dateDay = dMapper.string2LocalDate(dto.getDancingDate());
        List<DateEntity> schedule = dRepo.findAll();
        List<DateEntity> thisDay = new ArrayList();
        
        //Verificacion de Horario
        if(moment.getHour()<9 || moment.getHour()>17){
            System.out.println("Verificacion Horario");
            dto = this.blank(dto);
            dto.setDancingTime("ERROR TIME Hours should be set from 9 am to 6 pm");
        }
        
        //Verificacion de Dia de la Semana
        if(0 == dateDay.getDayOfWeek().compareTo(DayOfWeek.SUNDAY)||
                0 == dateDay.getDayOfWeek().compareTo(DayOfWeek.SATURDAY)){
            System.out.println("Verificacion Dia de la Semana");
            dto = this.blank(dto);
            dto.setDancingDate("ERROR DAY On Saturdays and Sundays Death rests");
        }

        //Verificacion de Email
        schedule.stream().filter(dateEntity -> (dateEntity.getDancingDate().equals(dateDay))).forEachOrdered(dateEntity -> {
            thisDay.add(dateEntity);
        });
        
        for (DateEntity dateEntity : thisDay) {
            if(dateEntity.getEmail().equals(dto.getEmail())){
                System.out.println("Verificacion email");
                System.out.println(dateEntity.getEmail());
                dto = this.blank(dto);
                dto.setEmail("ERROR EMAIL You can only dance once a day");
                break;
            }
        }
        
        //Verificacion de Horario ocupado
        for (DateEntity dateEntity : thisDay) {
            if(dateEntity.getDancingTime().getHour() == moment.getHour()){
                System.out.println("Verificacion Horario Ocupado");
                dto = this.blank(dto);
                dto.setDancingTime("BUSY HOUR");
                break;
            }
        }
 
        return dto;
    }
    
    /**
     * Limpia un DTO para retornarlo a la verificacion
     * @param dto
     * @return 
     */
    private DateDTO blank (DateDTO dto){
        dto.setDancingDate("");
        dto.setDancingTime("");
        dto.setEmail("");
        dto.setId("");
        dto.setName("");
        return dto;
    }

    
}

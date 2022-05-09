package com.aec.dwd.service;

import com.aec.dwd.model.DateDTO;
import java.util.List;

/**
 * @author Adrian E. Camus
 */
public interface DateService {
    
    /**
     * Receives a DTO object and creates an entity persists it and returns it
     * @param dto
     * @return DateDTO
     */
    public DateDTO save(DateDTO dto);
    
    /**
     * Returns a list of DTOs with all records
     * @return List(DateDTO)
     */
    public List<DateDTO> getAll();
    
    /**
     * Receive a DTO object and change a record with the values ​​of that object
     * @param dto
     * @return DateDTO
     */
    public DateDTO update(DateDTO dto);
    
    /**
     * Receive a String ID, set the active field in the DB to false and persist
     * @param id 
     */
    public void delete(String id);
    
    /**
     * Receives a String ID, looks up that value in the DB and returns a data 
     * transfer object corresponding to that entity.
     * @param id
     * @return DateDTO
     */
    public DateDTO getDetails(String id);
    
    /**
     * Receives a dto with a parameter day, and returns a list of transfer 
     * objects that have that day as a parameter.
     * @param day
     * @return List(DateDTO)
     */
    public List<DateDTO> getDate(DateDTO day);

}

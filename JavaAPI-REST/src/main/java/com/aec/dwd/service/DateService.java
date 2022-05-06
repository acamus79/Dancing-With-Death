package com.aec.dwd.service;

import com.aec.dwd.model.DateDTO;
import java.util.List;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
public interface DateService {
    
    /**
     * Recibe un objeto DTO y crea una entidad
     * Retorna la entidad persistida
     * @param dto
     * @return DateDTO
     */
    public DateDTO save(DateDTO dto);
    
    /**
     * Retorna una lista de DTO con todos los registros
     * @return List<DateDTO>
     */
    public List<DateDTO> getAll();
    
    /**
     * Recibe un objeto DTO y cambia un registro con los valores de ese objeto
     * @param dto
     * @return DateDTO
     */
    public DateDTO update(DateDTO dto);
    
    /**
     * Recibe un String iD 
     * Desactiva el registro en la BD y persiste
     * @param id 
     */
    public void delete(String id);
    
    /**
     * recibe un String iD 
     * devuelve el objeto con ese iD
     * @param id
     * @return DateDTO
     */
    public DateDTO getDetails(String id);
    
    /**
     * recibe un objeto DTO con un parametro dia 
     * devuelve una lista de objetos que contengan el dia
     * @param day
     * @return List<DateDTO>
     */
    public List<DateDTO> getDate(DateDTO day);

}

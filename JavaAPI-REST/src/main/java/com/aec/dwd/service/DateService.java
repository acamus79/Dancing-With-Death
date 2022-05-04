package com.aec.dwd.service;

import com.aec.dwd.model.DateDTO;
import java.util.List;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
public interface DateService {
    
    public DateDTO save(DateDTO dto);

    public List<DateDTO> getAll();

    public DateDTO update(String id, DateDTO dto);

    public void delete(String id);
    
    public DateDTO getDetails(String id);

}

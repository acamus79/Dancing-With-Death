package com.aec.dwd.repositories;

import com.aec.dwd.model.DateEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Adrian E. Camus
 */
public interface DateRepository extends JpaRepository<DateEntity, String>{
    
    /**
     * Method to search only the records with the active field set to true, 
     * returns a list sorted by date and time in descending order
     * @return List(Entity)
     */
    @Query("SELECT c FROM DateEntity c WHERE c.active = true "
            + "ORDER BY c.dancingDate, c.dancingTime desc")
    public List<DateEntity> searchActive();
    
}

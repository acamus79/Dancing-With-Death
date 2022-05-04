package com.aec.dwd.repositories;

import com.aec.dwd.model.DateEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
public interface DateRepository extends JpaRepository<DateEntity, String>{
    
    @Query("SELECT c FROM DateEntity c WHERE c.active = true")
    public List<DateEntity> searchActive();
    
}

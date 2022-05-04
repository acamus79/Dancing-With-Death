package com.aec.dwd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateDTO {
    
    private String id;
    private String dancingDate;
    private String dancingTime;
    private String name;
    private String email;
        
}


package com.aec.dwd.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * @author Adrian E. Camus
 */
@Entity
@Table(name = "date")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE date SET active = false WHERE id=?")
@Where(clause = "active = true")
public class DateEntity implements Serializable {
    
    private static final long serialVersionUID = 8478674716638L;
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    /**
     * How to make a false delete in the DB, by default it is created in 
     * true(1) and with the SQLDelete annotation we change it to false(0)
     */
    private boolean active = Boolean.TRUE;
    
    @Column(name = "dancing_date", nullable = false)
    private LocalDate dancingDate;
    
    @Column(name = "dancing_time", nullable = false)
    private LocalTime dancingTime;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(nullable = false, length = 80)
    private String email;
}

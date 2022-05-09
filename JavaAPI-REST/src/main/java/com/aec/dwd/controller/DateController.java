package com.aec.dwd.controller;

import com.aec.dwd.model.DateEntity;
import com.aec.dwd.model.DateDTO;
import com.aec.dwd.repositories.DateRepository;
import com.aec.dwd.service.DateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adrian E. Camus
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/dwd")
public class DateController {
    
    @Autowired
    DateService dService;
    
    @Autowired
    DateRepository dRepo;
    
    /**
     * 
     * @return DateDTO
     */
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/all")
    public List<DateDTO> getAllDate(){
        return dService.getAll();
    }
    /**
     * 
     * @param day
     * @return List(Entity)
     */
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/date")
    public List<DateDTO> getDay(@RequestBody DateDTO day){
        return dService.getDate(day);
    }

    /**
     *
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    public DateEntity getDate(@PathVariable("id") String id){
        return dRepo.findById(id).orElse(new DateEntity());
    }

    /**
     *
     * @param dto
     * @return ResponseEntity
     */
    @PostMapping("/new")
    public ResponseEntity<DateDTO> saveDate(@RequestBody DateDTO dto){
        
        DateDTO ret = dService.save(dto);
        
        if(!ret.getId().isBlank()){
                return ResponseEntity.status(HttpStatus.CREATED).body(ret);
            }else{
                return ResponseEntity.status(HttpStatus.CONFLICT).body(ret);
            }
        
    }
    
    /**
     *
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id){
        dService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    /**
     *
     * @param dto
     * @return ResponseEntity
     */
    @PutMapping("/update")
    public ResponseEntity<DateDTO> updateDate(@RequestBody DateDTO dto){
        DateDTO editedDate = dService.update(dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedDate);
    }
    
}

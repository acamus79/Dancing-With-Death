/*
 * Sin licencia.
 * Uso para capacitación
 * 2021 Año de la Prevención y Lucha contra el COVID-19.
 */

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
 * 
 * @author Adrian E. Camus
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/dwd")
public class DateController {
    
    @Autowired
    DateService dService;
    
    @Autowired
    DateRepository dRepo;
    
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/all")
    public List<DateDTO> getAllDate(){
        return dService.getAll();
    }

    @GetMapping("/{id}")
    public DateEntity getDate(@PathVariable("id") String id){
        return dRepo.findById(id).orElse(new DateEntity());
    }

    @PostMapping("/new")
    public ResponseEntity<DateDTO> saveDate(@RequestBody DateDTO dto){
        
        DateDTO ret = dService.save(dto);
        
        if(!ret.getId().isBlank()){
                return ResponseEntity.status(HttpStatus.CREATED).body(ret);
            }else{
                return ResponseEntity.status(HttpStatus.CONFLICT).body(ret);
            }
        
    }
    
    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id){
        dService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity<DateDTO> updateDate(@RequestBody DateDTO dto){
        DateDTO editedDate = dService.update(dto.getId(), dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedDate);
    }
    
    
}

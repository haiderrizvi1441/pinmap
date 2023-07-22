package com.hr.pinmapbackend.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.hr.pinmapbackend.Entity.Pin;
import com.hr.pinmapbackend.Service.PinService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pins")
public class PinController {
    
    private final PinService pinService;

    @Autowired
    public PinController(PinService pinService){
        this.pinService = pinService;
    }

    // Get All Pins
    @GetMapping("/allpins")
    public List<Pin> getAllPins(){
        return pinService.getAllPins();
    }


    // Getting Pin By Id
    @GetMapping("/{id}")
    public ResponseEntity<Pin> getPinById(@PathVariable Long id){
        Pin pin = pinService.getPinById(id);
        if(pin != null){
            return ResponseEntity.ok(pin);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    // Creating Pins
    @PostMapping
    public ResponseEntity<Pin> createPin(@RequestBody Pin pin){
        Pin createdPin = pinService.createPin(pin);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPin);
    }

    // Updating Pins
    @PutMapping("/{id}")
    public ResponseEntity<Pin> updatePin(@PathVariable Long id, @RequestBody Pin pin){
        Pin updatedPin = pinService.updatePin(id, pin);
        if(updatedPin != null){
            return ResponseEntity.ok(updatedPin);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    // Deleting Pins by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePin(@PathVariable Long id){
        pinService.deletePin(id);
        return ResponseEntity.noContent().build();
    }



}

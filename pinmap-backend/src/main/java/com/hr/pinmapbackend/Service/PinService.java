package com.hr.pinmapbackend.Service;

import java.util.List;

import com.hr.pinmapbackend.Entity.Pin;

public interface PinService {

    // Getting all Pins 
    List<Pin> getAllPins();
    
    // Get Pin By id
    Pin getPinById(Long id);

    // Create Pin
    Pin createPin(Pin pin);

    // Update Pin By Id
    Pin updatePin(Long id, Pin pin);

    // Delete Pin by Id
    void deletePin(Long id);
}

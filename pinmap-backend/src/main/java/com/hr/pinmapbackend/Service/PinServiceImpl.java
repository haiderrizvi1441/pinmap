package com.hr.pinmapbackend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hr.pinmapbackend.Entity.Pin;
import com.hr.pinmapbackend.Exception.PinNotFoundException;
import com.hr.pinmapbackend.Repository.PinRepository;

@Service
public class PinServiceImpl implements PinService {
    
    private final PinRepository pinRepository;

    public PinServiceImpl(PinRepository pinRepository){
        this.pinRepository = pinRepository;
    }

    @Override
    public List<Pin> getAllPins() {
        return pinRepository.findAll();
    }

    @Override
    public Pin getPinById(Long id) {
        return pinRepository.findById(id).orElse(null);
    }

    @Override
    public Pin createPin(Pin pin) {
        return pinRepository.save(pin);
    }

    @Override
    public Pin updatePin(Long id, Pin pin) {
        Pin existingPin = pinRepository.findById(id).orElse(null);
        if(existingPin == null){
            // Handle Pin not found error
            throw new PinNotFoundException("Pin with ID:" + id + " not found");
        }

        // If Found , update with new Values
        existingPin.setDescription(pin.getDescription());
        existingPin.setLatitide(pin.getLatitide());
        existingPin.setLongitude(pin.getLongitude());

        return pinRepository.save(existingPin);
    }

    @Override
    public void deletePin(Long id) {
        Pin existingPin = pinRepository.findById(id).orElse(null);
        if(existingPin == null){
            throw new PinNotFoundException("Pin with ID: " + id + " not found");
        }

        pinRepository.deleteById(id);
        
    }
}

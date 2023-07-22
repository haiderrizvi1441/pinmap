package com.hr.pinmapbackend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double latitide;
    private double longitude;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getLatitide() {
        return latitide;
    }
    public void setLatitide(double latitide) {
        this.latitide = latitide;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public Pin(Long id, String description, double latitide, double longitude) {
        this.id = id;
        this.description = description;
        this.latitide = latitide;
        this.longitude = longitude;
    }
    public Pin() {
    }
    public Pin(Long id) {
        this.id = id;
    }

    
}

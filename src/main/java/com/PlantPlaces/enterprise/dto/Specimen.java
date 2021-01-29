package com.PlantPlaces.enterprise.dto;


import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Specimen {
    private String plantId;
    private String specimenId;
    private String latitude;
    private String longitude;
    private String description;
}

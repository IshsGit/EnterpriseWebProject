package com.PlantPlaces.enterprise.service;

import com.PlantPlaces.enterprise.dto.Specimen;

public interface ISpecimenService {
    /**
     * Fetch a specimen with a given id with a given name
     * @param id a unique identifier for a specimen
     * @return the matching specimen, or null if no matches found
     */
    Specimen fetchById(int id);

    Specimen save(Specimen specimen) throws Exception;
}

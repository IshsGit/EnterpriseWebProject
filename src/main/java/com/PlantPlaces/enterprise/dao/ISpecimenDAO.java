package com.PlantPlaces.enterprise.dao;

import com.PlantPlaces.enterprise.dto.Specimen;

public interface ISpecimenDAO {

    Specimen save(Specimen specimen) throws Exception;
}

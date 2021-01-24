package com.PlantPlaces.enterprise;

import com.PlantPlaces.enterprise.dto.Specimen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlantDiaryController {

    @RequestMapping("/")
    public String index(){
        return "start";
    }

    // Get all specimens
    @GetMapping("/specimen")
    public ResponseEntity fetchAllSpecimens(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/specimen/{id}/")
    public ResponseEntity fetchSpecifimens(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Create a new specimen object, given the data provided
     *
     * Returns one of the following status codes:
     * 201: successfully created a new specimen
     * 409: unable to create specimen, because it already exists
     *
     * @param specimen a JSON representation of a specimen object
     * @return the newly created specimen object
     */
    @PostMapping(value="/specimen", produces="application/json", consumes="application/json")
    public Specimen createSpecimen(@RequestBody Specimen specimen){
        // RequestBody parses through JSON obj and populates specimen's fields
        System.out.println(specimen.getSpecimenId());
        return specimen;
    }

    @DeleteMapping("/specimen/{id}/")
    public ResponseEntity deleteSpecimen(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

}

package com.PlantPlaces.enterprise;

import com.PlantPlaces.enterprise.dto.Specimen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// ctrl-shift-a search for version control systems to shelves changes
// Checkout only when finishing work and working on another branch
// You can unshelves changes and return back to default on the same branch

/**
 * The compiler for plant diary REST endpoints and web UI
 * <p>
 * This class handles the CRUH operations for my plant diary specimens, via HTTP actions
 * </p>
 * <p>
 * This class also serves HTML based web pages for UI interactions with plant specimens
 * </p>
 */
@Controller
public class PlantDiaryController {

    /**
     * Handle the / end point
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "start";
    }

    /**
     * Fetch a specimen with the given ID
     *
     * Given the paramter Id, find a specimen that corresponds to this unique Id
     *
     * Return one of the following status codes:
     * 200: Specimen found
     * 400: Specimen not found
     *
     * @Param id a unique identifier for this specimen
     */
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

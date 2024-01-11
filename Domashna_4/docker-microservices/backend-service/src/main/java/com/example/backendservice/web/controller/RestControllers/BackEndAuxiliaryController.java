package com.example.backendservice.web.controller.RestControllers;


import com.example.backendservice.model.enumerations.HeritageType;
import com.example.backendservice.service.AuxiliaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Controller used to get the data in order to fill the dropdown lists on the map page
 */
@RestController
@RequestMapping("/api/auxiliary")
public class BackEndAuxiliaryController {
    private final AuxiliaryService auxiliaryService;

    public BackEndAuxiliaryController(AuxiliaryService auxiliaryService) {
        this.auxiliaryService = auxiliaryService;
    }

    /**
     *
     * @return List<String> with all the cities in the database
     */
    @GetMapping("/cities")
    public List<String> getAllCities(){
        return auxiliaryService.getAllCities();
    }

    /**
     *
     * @return List<String> with all the Heritage Site types in the database
     */
    @GetMapping("/types")
    public List<String> getMappedHeritageTypes() {
        return auxiliaryService.mapHeritageTypesToStrings(auxiliaryService.getAllTypes());
    }
}

package com.example.backendservice.web.controller.RestControllers;

import com.example.backendservice.model.HeritageSite;
import com.example.backendservice.model.enumerations.HeritageType;
import com.example.backendservice.service.HeritageSiteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/home")
public class SiteNavigationRestController {

    private final HeritageSiteService heritageSiteService;

    public SiteNavigationRestController(HeritageSiteService heritageSiteService) {
        this.heritageSiteService = heritageSiteService;
    }

    @GetMapping("/filteredSites")
    public List<HeritageSite> getFilteredSites(@RequestParam(required = false) String city,
                                               @RequestParam(required = false) String type) {
        List<HeritageSite> filteredSites;

        if ((city != null && !city.equals("")) && (type != null && !type.equals(""))) {
            HeritageType pickedType = heritageSiteService.mapStringToHeritageType(type);
            filteredSites = heritageSiteService.listSitesByCityAndType(pickedType, city);
        } else if (city != null && !city.equals("")) {
            filteredSites = heritageSiteService.listSitesByCity(city);
        } else if (type != null && !type.equals("")) {
            HeritageType pickedType = heritageSiteService.mapStringToHeritageType(type);
            filteredSites = heritageSiteService.listSitesByType(pickedType);
        } else {
            filteredSites = heritageSiteService.listAll();
        }

        return filteredSites;
    }
}
package com.example.legacy_explorer.web.controller;

import com.example.legacy_explorer.model.HeritageSite;
import com.example.legacy_explorer.model.enumerations.HeritageType;
import com.example.legacy_explorer.service.AuxiliaryService;
import com.example.legacy_explorer.service.HeritageSiteService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/home")
public class SiteNavigationController {
    private final HeritageSiteService heritageSiteService;
    private final AuxiliaryService auxiliaryService;

    public SiteNavigationController(HeritageSiteService heritageSiteService, AuxiliaryService auxiliaryService) {
        this.heritageSiteService = heritageSiteService;
        this.auxiliaryService = auxiliaryService;
    }

    @GetMapping()
    public String getMapPage(@RequestParam(required = false) String city,
                             @RequestParam(required = false) String type,
                             Model model){
        List<String> cities = auxiliaryService.getAllCities();
        List<HeritageType> types = auxiliaryService.getAllTypes();
        List<String> convertedTypes = auxiliaryService.mapHeritageTypesToStrings(types);

        List<HeritageSite> filteredSites;

        if(city != null && type != null){
            HeritageType pickedType = heritageSiteService.mapStringToHeritageType(type);
            filteredSites = heritageSiteService.listSitesByCityAndType(pickedType, city);
        }else if(city != null){
            filteredSites = heritageSiteService.listSitesByCity(city);
        }else if(type != null){
            HeritageType pickedType = heritageSiteService.mapStringToHeritageType(type);
            filteredSites = heritageSiteService.listSitesByType(pickedType);
        }else{
            filteredSites = heritageSiteService.listAll();
        }

        model.addAttribute("cities", cities);
        model.addAttribute("types", convertedTypes);
        model.addAttribute("filteredSites", filteredSites); //Add filtered sites

        // Convert filteredSites to JSON and pass it to the model as a string
        model.addAttribute("filteredSitesJSON", new Gson().toJson(filteredSites));

        model.addAttribute("bodyContent", "map-page");
        return "master-template";
    }

    @GetMapping("/heritageSites")
    public String getSitesByType(@RequestParam(required = false) String type, Model model){
        if(type != null && !type.isEmpty()){
            HeritageType pickedType = heritageSiteService.mapStringToHeritageType(type);
            model.addAttribute("heritageSites", heritageSiteService.listSitesByType(pickedType));
            if(heritageSiteService.listSitesByType(pickedType).isEmpty()){
                model.addAttribute("searchedType", "Invalid type: " + type);
            }else{
                model.addAttribute("searchedType", type);
            }
        }else{
            model.addAttribute("heritageSites", heritageSiteService.listAll());
            model.addAttribute("searchedType", "All lists");
        }
        model.addAttribute("bodyContent", "list-sites");
        return "master-template";
    }
}


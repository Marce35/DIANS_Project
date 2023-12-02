package com.example.prototypemodule.web.controller;


import com.example.prototypemodule.model.HeritageSite;
import com.example.prototypemodule.model.enumerations.HeritageType;
import com.example.prototypemodule.service.AuxiliaryService;
import com.example.prototypemodule.service.HeritageSiteService;
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
    public String getMapPage(Model model){
        List<String> cities = auxiliaryService.getAllCities();
        List<HeritageType> types = auxiliaryService.getAllTypes();
        List<String> convertedTypes = auxiliaryService.mapHeritageTypesToStrings(types);

        model.addAttribute("cities", cities);
        model.addAttribute("types", convertedTypes);
        model.addAttribute("bodyContent", "map-page");
        return "master-template";
    }

    @GetMapping("/heritageSites")
    public String getSitesByType(@RequestParam(required = false) String type, Model model){
        if(type != null && !type.isEmpty()){
            HeritageType pickedType = heritageSiteService.mapStringToHeritageType(type);
            model.addAttribute("heritageSites", heritageSiteService.listSitesByType(pickedType));
            model.addAttribute("searchedType", type);
        }else{
            model.addAttribute("heritageSites", heritageSiteService.listAll());
        }
        model.addAttribute("bodyContent", "list-sites");
        return "master-template";
    }
}

package com.example.prototypemodule.service;

import com.example.prototypemodule.model.HeritageSite;
import com.example.prototypemodule.model.enumerations.HeritageType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HeritageSiteService {
    List<HeritageSite> listAll();

    List<HeritageSite> listSitesByType(HeritageType type);
    List<HeritageSite> listSitesByCity(String city);
    List<HeritageSite> listSitesByCitiesAndTypes(List<HeritageType> types, List<String> cities);
    List<HeritageSite> listSitesByCityAndType(HeritageType type, String city);

    HeritageType mapStringToHeritageType(String type);
    List<HeritageType> mapStringsToHeritageTypes(List<String> types);

}

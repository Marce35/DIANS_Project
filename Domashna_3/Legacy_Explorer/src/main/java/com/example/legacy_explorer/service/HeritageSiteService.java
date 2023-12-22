package com.example.legacy_explorer.service;


import com.example.legacy_explorer.model.HeritageSite;
import com.example.legacy_explorer.model.enumerations.HeritageType;

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

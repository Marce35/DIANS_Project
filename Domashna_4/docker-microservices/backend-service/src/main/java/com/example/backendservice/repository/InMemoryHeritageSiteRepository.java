package com.example.backendservice.repository;


import com.example.backendservice.bootstrap.DataHolder;
import com.example.backendservice.model.HeritageSite;
import com.example.backendservice.model.enumerations.HeritageType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryHeritageSiteRepository {
    public List<HeritageSite> findAll(){
        return DataHolder.heritageSiteList;
    }

    public List<HeritageSite> findSitesByType(HeritageType type){
        return DataHolder.heritageSiteList.stream()
                .filter(site -> site.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<HeritageSite> findSitesByCity(String city){
        return DataHolder.heritageSiteList.stream()
                .filter(site -> site.getCity().toLowerCase().equals(city.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<HeritageSite> findSitesByCityAndType(String city, HeritageType type){
        return DataHolder.heritageSiteList.stream()
                .filter(site -> site.getCity().toLowerCase().equals(city.toLowerCase()) && site.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<HeritageSite> findSitesByCitiesAndTypes(List<String> cities, List<HeritageType> types){
        return DataHolder.heritageSiteList
                .stream()
                .filter(site -> cities.stream().anyMatch(city -> city.equalsIgnoreCase(site.getCity())) && types.contains(site.getType()))
                .collect(Collectors.toList());
    }
}

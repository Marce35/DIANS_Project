package com.example.legacy_explorer.repository;

import com.example.legacy_explorer.bootstrap.DataHolder;
import com.example.legacy_explorer.model.HeritageSite;
import com.example.legacy_explorer.model.enumerations.HeritageType;
import org.springframework.stereotype.Repository;


import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryAuxiliaryRepository {
    public List<String> getCities(){
        List<String> allCities = DataHolder.heritageSiteList.stream()
                .map(HeritageSite::getCity)
                .collect(Collectors.toList());
        Set<String> uniqueCities = new HashSet<>(allCities);
        List<String> sortedCities = uniqueCities.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        return sortedCities;
    }

    public List<HeritageType> getTypes(){
        List<HeritageType> allTypes = DataHolder.heritageSiteList.stream()
                .map(HeritageSite::getType)
                .collect(Collectors.toList());
        Set<HeritageType> uniqueTypes = new HashSet<>(allTypes);
        return new ArrayList<>(uniqueTypes);
    }
}


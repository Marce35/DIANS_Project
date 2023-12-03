package com.example.prototypemodule.repository;

import com.example.prototypemodule.bootstrap.DataHolder;
import com.example.prototypemodule.model.HeritageSite;
import com.example.prototypemodule.model.enumerations.HeritageType;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class InMemoryAuxiliaryRepository {
    public List<String> getCities(){
        List<String> allCities = DataHolder.heritageSiteList.stream()
                .map(HeritageSite::getCity)
                .collect(Collectors.toList());
        Set<String> uniqueCities = new HashSet<>(allCities);
        return new ArrayList<>(uniqueCities);
    }

    public List<HeritageType> getTypes(){
        List<HeritageType> allTypes = DataHolder.heritageSiteList.stream()
                .map(HeritageSite::getType)
                .collect(Collectors.toList());
        Set<HeritageType> uniqueTypes = new HashSet<>(allTypes);
        return new ArrayList<>(uniqueTypes);
    }
}

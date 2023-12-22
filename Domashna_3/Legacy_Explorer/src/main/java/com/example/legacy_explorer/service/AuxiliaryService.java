package com.example.legacy_explorer.service;


import com.example.legacy_explorer.model.enumerations.HeritageType;

import java.util.List;

public interface AuxiliaryService {
    List<String> getAllCities();

    List<HeritageType> getAllTypes();
    List<String> mapHeritageTypesToStrings(List<HeritageType> heritageTypes);
}
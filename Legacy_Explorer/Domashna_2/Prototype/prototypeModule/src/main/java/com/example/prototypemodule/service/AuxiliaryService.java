package com.example.prototypemodule.service;

import com.example.prototypemodule.model.enumerations.HeritageType;

import java.util.List;

public interface AuxiliaryService {
    List<String> getAllCities();

    List<HeritageType> getAllTypes();
    List<String> mapHeritageTypesToStrings(List<HeritageType> heritageTypes);
}

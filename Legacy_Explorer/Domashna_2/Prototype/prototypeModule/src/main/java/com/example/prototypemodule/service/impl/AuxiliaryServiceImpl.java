package com.example.prototypemodule.service.impl;


import com.example.prototypemodule.model.enumerations.HeritageType;
import com.example.prototypemodule.repository.InMemoryAuxiliaryRepository;
import com.example.prototypemodule.service.AuxiliaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuxiliaryServiceImpl implements AuxiliaryService {
    private final InMemoryAuxiliaryRepository auxiliaryRepository;

    public AuxiliaryServiceImpl(InMemoryAuxiliaryRepository auxiliaryRepository) {
        this.auxiliaryRepository = auxiliaryRepository;
    }

    @Override
    public List<String> getAllCities() {
        return auxiliaryRepository.getCities();
    }

    @Override
    public List<HeritageType> getAllTypes() {
        return auxiliaryRepository.getTypes();
    }

    @Override
    public List<String> mapHeritageTypesToStrings(List<HeritageType> heritageTypes) {
        List<String> typeStrings = new ArrayList<>();
        for (HeritageType type : heritageTypes) {
            typeStrings.add(type.name()); // Get the name of the enum value as a string
        }
        return typeStrings;
    }
}

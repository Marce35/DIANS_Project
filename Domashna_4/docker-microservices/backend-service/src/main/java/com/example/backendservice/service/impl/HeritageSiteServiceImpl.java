package com.example.backendservice.service.impl;


import com.example.backendservice.model.HeritageSite;
import com.example.backendservice.model.enumerations.HeritageType;
import com.example.backendservice.model.exceptions.InvalidSiteTypeException;
import com.example.backendservice.repository.InMemoryHeritageSiteRepository;
import com.example.backendservice.service.HeritageSiteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeritageSiteServiceImpl implements HeritageSiteService {

    private final InMemoryHeritageSiteRepository heritageSiteRepository;

    public HeritageSiteServiceImpl(InMemoryHeritageSiteRepository heritageSiteRepository) {
        this.heritageSiteRepository = heritageSiteRepository;
    }

    @Override
    public List<HeritageSite> listAll() {
        return heritageSiteRepository.findAll();
    }

    @Override
    public List<HeritageSite> listSitesByType(HeritageType type) {
        return heritageSiteRepository.findSitesByType(type);
    }

    @Override
    public List<HeritageSite> listSitesByCity(String city) {
        return heritageSiteRepository.findSitesByCity(city);
    }

    @Override
    public List<HeritageSite> listSitesByCityAndType(HeritageType type, String city) {
        return heritageSiteRepository.findSitesByCityAndType(city, type);
    }

    @Override
    public List<HeritageSite> listSitesByCitiesAndTypes(List<HeritageType> types, List<String> cities) {
        return heritageSiteRepository.findSitesByCitiesAndTypes(cities, types);
    }

    @Override
    public HeritageType mapStringToHeritageType(String type) throws InvalidSiteTypeException {
        try {
            return HeritageType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            // Handle the case where the provided type doesn't match any enum value
            throw new InvalidSiteTypeException("Invalid heritage site type: " + type);
        }
    }

    @Override
    public List<HeritageType> mapStringsToHeritageTypes(List<String> types) {
        List<HeritageType> heritageTypes = new ArrayList<>();
        for (String type : types) {
            try {
                HeritageType heritageType = HeritageType.valueOf(type.toUpperCase());
                heritageTypes.add(heritageType);
            } catch (IllegalArgumentException | NullPointerException e) {
                // Handle the case where the provided type doesn't match any enum value
                // Maybe skip this entry or log an error
            }
        }
        return heritageTypes;
    }
}

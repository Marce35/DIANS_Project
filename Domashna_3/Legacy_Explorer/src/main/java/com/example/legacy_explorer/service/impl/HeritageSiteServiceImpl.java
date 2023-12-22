package com.example.legacy_explorer.service.impl;


import com.example.legacy_explorer.model.HeritageSite;
import com.example.legacy_explorer.model.enumerations.HeritageType;
import com.example.legacy_explorer.repository.InMemoryHeritageSiteRepository;
import com.example.legacy_explorer.service.HeritageSiteService;
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
    public HeritageType mapStringToHeritageType(String type) {
        try {
            return HeritageType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            // Handle the case where the provided type doesn't match any enum value
            return null; // Or throw an exception, or use a default value
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

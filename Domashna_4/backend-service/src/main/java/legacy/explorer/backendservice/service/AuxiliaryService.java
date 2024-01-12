package legacy.explorer.backendservice.service;



import legacy.explorer.backendservice.model.enumerations.HeritageType;

import java.util.List;

public interface AuxiliaryService {
    List<String> getAllCities();

    List<HeritageType> getAllTypes();
    List<String> mapHeritageTypesToStrings(List<HeritageType> heritageTypes);
}
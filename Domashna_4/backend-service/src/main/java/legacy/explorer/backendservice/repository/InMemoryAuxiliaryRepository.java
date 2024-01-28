package legacy.explorer.backendservice.repository;


import legacy.explorer.backendservice.bootstrap.DataHolder;
import legacy.explorer.backendservice.model.HeritageSite;
import legacy.explorer.backendservice.model.enumerations.HeritageType;
import org.springframework.stereotype.Repository;


import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryAuxiliaryRepository {
    /**
     * returns the list of all the cities in the database
     * @return
     */
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

    /**
     * returns the list of all the types in the database
     * @return
     */
    public List<HeritageType> getTypes(){
        List<HeritageType> allTypes = DataHolder.heritageSiteList.stream()
                .map(HeritageSite::getType)
                .collect(Collectors.toList());
        Set<HeritageType> uniqueTypes = new HashSet<>(allTypes);
        return new ArrayList<>(uniqueTypes);
    }
}


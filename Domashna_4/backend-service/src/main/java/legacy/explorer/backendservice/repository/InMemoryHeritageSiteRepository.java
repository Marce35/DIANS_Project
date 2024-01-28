package legacy.explorer.backendservice.repository;



import legacy.explorer.backendservice.bootstrap.DataHolder;
import legacy.explorer.backendservice.model.HeritageSite;
import legacy.explorer.backendservice.model.enumerations.HeritageType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryHeritageSiteRepository {
    /**
     * returns list of all the heritageSite
     * @return
     */
    public List<HeritageSite> findAll(){
        return DataHolder.heritageSiteList;
    }

    /**
     *
     * @param type - HeritageType object
     * @return List of HeritageSite
     */
    public List<HeritageSite> findSitesByType(HeritageType type){
        return DataHolder.heritageSiteList.stream()
                .filter(site -> site.getType().equals(type))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param city - city to search heritage sites for
     * @return
     */
    public List<HeritageSite> findSitesByCity(String city){
        return DataHolder.heritageSiteList.stream()
                .filter(site -> site.getCity().toLowerCase().equals(city.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param city
     * @param type
     * @return list of HeritageSites that satisfy the provided city and type
     */
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

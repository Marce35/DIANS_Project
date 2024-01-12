package legacy.explorer.backendservice.service;




import legacy.explorer.backendservice.model.HeritageSite;
import legacy.explorer.backendservice.model.enumerations.HeritageType;
import legacy.explorer.backendservice.model.exceptions.InvalidSiteTypeException;

import java.util.List;


public interface HeritageSiteService {
    List<HeritageSite> listAll();

    List<HeritageSite> listSitesByType(HeritageType type);
    List<HeritageSite> listSitesByCity(String city);
    List<HeritageSite> listSitesByCitiesAndTypes(List<HeritageType> types, List<String> cities);
    List<HeritageSite> listSitesByCityAndType(HeritageType type, String city);

    HeritageType mapStringToHeritageType(String type) throws InvalidSiteTypeException;
    List<HeritageType> mapStringsToHeritageTypes(List<String> types);

}

package legacy.explorer.backendservice.web.controller.RestControllers;


import legacy.explorer.backendservice.model.HeritageSite;
import legacy.explorer.backendservice.model.enumerations.HeritageType;
import legacy.explorer.backendservice.model.exceptions.InvalidSiteTypeException;
import legacy.explorer.backendservice.service.HeritageSiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller used to filter the Heritage sites data needed in the map.html
 */
@RestController
@RequestMapping("/api/filtered-sites")
public class BackEndMapNavigationController {

    private final HeritageSiteService heritageSiteService;

    public BackEndMapNavigationController(HeritageSiteService heritageSiteService) {
        this.heritageSiteService = heritageSiteService;
    }

    /**
     *
     * @param city
     * @param type
     * @return List<HeritageSite> list of filtered heritage sites
     * @throws InvalidSiteTypeException
     */
    @GetMapping()
    public List<HeritageSite> getFilteredSites(@RequestParam(required = false) String city,
                                               @RequestParam(required = false) String type) throws InvalidSiteTypeException {
        List<HeritageSite> filteredSites;

        if ((city != null && !city.equals("")) && (type != null && !type.equals(""))) {
            HeritageType pickedType = heritageSiteService.mapStringToHeritageType(type);
            filteredSites = heritageSiteService.listSitesByCityAndType(pickedType, city);
        } else if (city != null && !city.equals("")) {
            filteredSites = heritageSiteService.listSitesByCity(city);
        } else if (type != null && !type.equals("")) {
            HeritageType pickedType = heritageSiteService.mapStringToHeritageType(type);
            filteredSites = heritageSiteService.listSitesByType(pickedType);
        } else {
            filteredSites = heritageSiteService.listAll();
        }

        return filteredSites;
    }
}
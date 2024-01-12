package legacy.explorer.backendservice.web.controller.RestControllers;


import legacy.explorer.backendservice.model.HeritageSite;
import legacy.explorer.backendservice.model.enumerations.HeritageType;
import legacy.explorer.backendservice.service.HeritageSiteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;

/**
 * Controller used to fill the table data with Heritage sites in the list-sites.html
 */
@RestController
@RequestMapping("api/list-sites")
public class BackEndSiteNavigationController {
    private final HeritageSiteService heritageSiteService;


    public BackEndSiteNavigationController(HeritageSiteService heritageSiteService) {
        this.heritageSiteService = heritageSiteService;
    }


    /**
     *
     * @param type - Heritage Site type:
     *      Valid inputs:    MUSEUM,
     *                       LIBRARY,
     *                       ARCHAEOLOGICAL_SITE,
     *                       CHURCH,
     *                       MONASTERY,
     *                       MEMORIAL_HOUSE
     * @return ResponseEntity<List<HeritageSite>> heritageSites by the requested type
     */
    @GetMapping()
    public ResponseEntity<List<HeritageSite>> getSitesByType(@RequestParam(required = false) String type){
        try{
            List<HeritageSite> heritageSites;
            if(type != null && !type.isEmpty()){
                HeritageType pickedType = heritageSiteService.mapStringToHeritageType(type);
                heritageSites = heritageSiteService.listSitesByType(pickedType);
            }else{
                heritageSites = heritageSiteService.listAll();
            }

            if(heritageSites.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
            }

            return ResponseEntity.ok(heritageSites);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }
}


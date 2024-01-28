package legacy.explorer.frontendservice.web.Controller.RestControllers;

import legacy.explorer.frontendservice.model.HeritageSite;
import legacy.explorer.frontendservice.web.Controller.BackEndRequestHelper.BackEndProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/bridge/api")
public class BridgeController {

    private final RestTemplate restTemplate;
    private final String backendBaseUrl;


    public BridgeController(RestTemplate restTemplate, BackEndProperties backEndProperties) {
        this.restTemplate = restTemplate;
        this.backendBaseUrl = BackEndProperties.getBaseUrl();
    }

    /**
     *
     * @param city
     * @param type
     * @return ResponseEntity of the filtered sites
     */
    @GetMapping("/filtered-sites")
    @ResponseBody
    public ResponseEntity<List<HeritageSite>> getFilteredSites(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String type) {

        try {
            // Build the URL based on the parameters
            String backendUrl = backendBaseUrl + "/api/filtered-sites";
            if (city != null || type != null) {
                backendUrl += "?";
            }
            if (city != null) {
                backendUrl += "city=" + city;
            }
            if (type != null) {
                backendUrl += (city != null ? "&" : "") + "type=" + type;
            }

            // Call BackendController endpoint
            ResponseEntity<List<HeritageSite>> responseEntity = restTemplate.exchange(
                    backendUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<HeritageSite>>() {});

            return ResponseEntity.status(responseEntity.getStatusCode())
                    .body(responseEntity.getBody());

        } catch (HttpClientErrorException e) {
            // Handle HTTP client errors
            return ResponseEntity.status(e.getRawStatusCode()).build();
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

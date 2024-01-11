package com.example.frontendservice.web.Controller;


import com.example.frontendservice.model.HeritageSite;
import com.example.frontendservice.web.Controller.BackEndRequestHelper.BackEndProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/home")
public class MainController {
    private final RestTemplate restTemplate;
    private final String backendBaseUrl;

    public MainController(RestTemplate restTemplate, BackEndProperties backEndProperties) {
        this.restTemplate = restTemplate;
        this.backendBaseUrl = backEndProperties.getBaseUrl();
    }

    @GetMapping()
    public String getMapPage(@RequestParam(required = false) String city,
                             @RequestParam(required = false) String type,
                             Model model){
        // Fetch cities and handle errors
        List<String> cities = fetchCitiesFromBackend(model);

        // Fetch heritage types and handle errors
        List<String> convertedTypes = fetchHeritageTypesFromBackend(model);

        model.addAttribute("cities", cities);
        model.addAttribute("types", convertedTypes);


        model.addAttribute("bodyContent", "map-page");
        return "master-template";
    }

    private List<String> fetchCitiesFromBackend(Model model) {
        try {
            ResponseEntity<List<String>> responseEntity = restTemplate.exchange(
                    backendBaseUrl + "/api/auxiliary/cities",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<String>>() {
                    });

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            } else {
                // Handle errors and return default values
                model.addAttribute("error", "Error fetching cities");
                return Collections.emptyList();
            }
        } catch (HttpClientErrorException e) {
            // Handle HTTP client errors (e.g., 404 Not Found)
            model.addAttribute("error", "Error fetching cities: " + e.getMessage());
            return Collections.emptyList();
        } catch (Exception e) {
            // Handle other exceptions
            model.addAttribute("error", "Error fetching cities: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    private List<String> fetchHeritageTypesFromBackend(Model model) {
        try {
            ResponseEntity<List<String>> responseEntity = restTemplate.exchange(
                    backendBaseUrl + "/api/auxiliary/types",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<String>>() {
                    });

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            } else {
                // Handle errors and return default values
                model.addAttribute("error", "Error fetching heritage types");
                return Collections.emptyList();
            }
        } catch (HttpClientErrorException e) {
            // Handle HTTP client errors (e.g., 404 Not Found)
            model.addAttribute("error", "Error fetching heritage types: " + e.getMessage());
            return Collections.emptyList();
        } catch (Exception e) {
            // Handle other exceptions
            model.addAttribute("error", "Error fetching heritage types: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @GetMapping("/heritageSites")
    public String getSitesByType(@RequestParam(required = false) String type, Model model){
        try {
            List<HeritageSite> heritageSites;
            if (type != null && !type.isEmpty()) {
                ResponseEntity<List<HeritageSite>> responseEntity =
                        restTemplate.exchange(backendBaseUrl + "/api/list-sites?type=" + type,
                                HttpMethod.GET, null, new ParameterizedTypeReference<List<HeritageSite>>() {
                                });

                heritageSites = responseEntity.getBody();
            } else {
                ResponseEntity<List<HeritageSite>> responseEntity =
                        restTemplate.exchange(backendBaseUrl + "/api/list-sites",
                                HttpMethod.GET, null, new ParameterizedTypeReference<List<HeritageSite>>() {
                                });

                heritageSites = responseEntity.getBody();
            }

            model.addAttribute("heritageSites", heritageSites);

        } catch (Exception e) {
            model.addAttribute("error", "Error fetching heritage sites: " + e.getMessage());
            model.addAttribute("heritageSites", Collections.emptyList());
        }

        model.addAttribute("bodyContent", "list-sites");
        return "master-template";
    }
}



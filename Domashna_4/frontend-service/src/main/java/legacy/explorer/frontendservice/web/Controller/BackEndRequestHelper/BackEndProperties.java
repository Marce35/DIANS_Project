package legacy.explorer.frontendservice.web.Controller.BackEndRequestHelper;


import org.springframework.stereotype.Component;

@Component
public class BackEndProperties {
    public static String baseUrl = "http://backend-service:9090";

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        BackEndProperties.baseUrl = baseUrl;
    }
}

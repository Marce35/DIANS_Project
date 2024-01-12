package legacy.explorer.backendservice.model;



import legacy.explorer.backendservice.model.enumerations.HeritageType;
import legacy.explorer.backendservice.model.helperClasses.Location;
import lombok.Data;

@Data
public class HeritageSite {
    private String name;
    private String website;
    private String city;
    private String street;
    private HeritageType type;
    private String email;
    private String phoneNumber;
    private String nameEnglish;
    private String openingHours;
    private Location coordinates;

    public HeritageSite(String name, String website, String city,
                        String street, HeritageType type, String email,
                        String phoneNumber, String nameEnglish,
                        String openingHours, Location coordinates) {
        this.name = name;
        this.website = website;
        this.city = city;
        this.street = street;
        this.type = type;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nameEnglish = nameEnglish;
        this.openingHours = openingHours;
        this.coordinates = coordinates;
    }

    public HeritageSite() {
    }
}


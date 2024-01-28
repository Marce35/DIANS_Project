package legacy.explorer.backendservice.bootstrap;

import jakarta.annotation.PostConstruct;
import legacy.explorer.backendservice.model.HeritageSite;
import legacy.explorer.backendservice.model.enumerations.HeritageType;
import legacy.explorer.backendservice.model.helperClasses.Location;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Initializing the database
 */
@Component
public class DataHolder {
    public static List<HeritageSite> heritageSiteList = null;

    /**
     * map each line into a heritageSite object
     * @param line
     * @return HeritageSite
     */
    private HeritageSite createHeritageSiteObject(String line) {
        HeritageSite heritageSite = new HeritageSite();
        String[] attributes = line.split(",");
        heritageSite.setName(attributes[0]);
        heritageSite.setWebsite(attributes[1]);
        heritageSite.setCity(attributes[2]);
        heritageSite.setStreet(attributes[3]);
        heritageSite.setType(HeritageType.valueOf(attributes[4].toUpperCase()));
        heritageSite.setEmail(attributes[5]);
        heritageSite.setPhoneNumber(attributes[6]);
        heritageSite.setNameEnglish(attributes[7]);
        heritageSite.setOpeningHours(attributes[8]);
        heritageSite.setCoordinates(new Location(
                Double.parseDouble(attributes[9]), Double.parseDouble(attributes[10])));
        return heritageSite;
    }

    /**
     * getting the data from the csv file
     */
    @PostConstruct
    public void init() {
        heritageSiteList = new ArrayList<>();

        try {
            // Load the CSV file as a resource
            InputStream inputStream = getClass().getResourceAsStream("/filtered_database.csv");
            if (inputStream != null) {
                Scanner scanner = new Scanner(inputStream);
                // Skip the first two lines
                scanner.nextLine();
                scanner.nextLine();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    HeritageSite heritageSite = createHeritageSiteObject(line);
                    heritageSiteList.add(heritageSite);
                }
                scanner.close();
            } else {
                System.err.println("Failed to load CSV file.");
            }
        } catch (Exception e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
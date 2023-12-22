package com.example.legacy_explorer.bootstrap;

import com.example.legacy_explorer.model.HeritageSite;
import com.example.legacy_explorer.model.enumerations.HeritageType;
import com.example.legacy_explorer.model.helperClasses.Location;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class DataHolder {
    public static List<HeritageSite> heritageSiteList = null;

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

    @PostConstruct
    public void init() throws FileNotFoundException {
        heritageSiteList = new ArrayList<>();

        ClassLoader loader = DataHolder.class.getClassLoader();
        Scanner scanner = new Scanner(new File(loader.getResource("filtered_database.csv").getFile()));

        scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            HeritageSite heritageSite = createHeritageSiteObject(line);
            heritageSiteList.add(heritageSite);
        }

        scanner.close();
    }
}

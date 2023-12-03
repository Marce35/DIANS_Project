package com.example.prototypemodule.model;


import com.example.prototypemodule.model.enumerations.HeritageType;
import com.example.prototypemodule.model.helperClasses.Location;
import lombok.Data;

@Data
public class HeritageSite {
    private String name;
    private String city;
    private HeritageType type;

    private Location coordinates;

    public HeritageSite(String name, String city, HeritageType type, Location coordinates) {
        this.name = name;
        this.city = city;
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public HeritageType getType() {
        return type;
    }

    public void setType(HeritageType type) {
        this.type = type;
    }

    public Location getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Location coordinates) {
        this.coordinates = coordinates;
    }
}

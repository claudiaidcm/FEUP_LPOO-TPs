package com.aor.refactoring.example6;

public class Location {

    private String latitude;
    private String longitude;
    private String name;

    public Location(String latitude, String longitude, String name) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return  this.latitude + "," + this.longitude + " (" + this.name + ")";
    }
}

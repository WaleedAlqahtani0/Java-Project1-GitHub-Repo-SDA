package com.example.FirstProject.FirstProject.Entity;

import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class Online extends Section {

    private int totalHours;
    private String location;

    public Online() {
    }

    public Online( String roomNumber, String instructor, int totalHours, String location) {
        super(roomNumber, instructor);
        this.totalHours = totalHours;
        this.location = location;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Online online = (Online) o;
        return totalHours == online.totalHours && Objects.equals(location, online.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHours, location);
    }

    @Override
    public String toString() {
        return "Online{" +
                "totalHours=" + totalHours +
                ", location='" + location + '\'' +
                '}';
    }

}

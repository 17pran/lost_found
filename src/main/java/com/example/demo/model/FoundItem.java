package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class FoundItem {

    @Id
    @GeneratedValue
    private Long id;

    private String itemName;
    private String description;
    private String location;
    private String date;   // <-- NEW FIELD

    public FoundItem() {}

    public FoundItem(String itemName, String description, String location, String date) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

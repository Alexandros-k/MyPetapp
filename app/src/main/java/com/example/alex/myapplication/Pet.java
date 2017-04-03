package com.example.alex.myapplication;

/**
 * Created by Alex on 3/28/2017.
 */

public class Pet {
    String name,race,text,species,id;
    int image;

    public Pet(String species, String name, String race,  int image, String text,String id) {
        this.name = name;
        this.race = race;
        this.text = text;
        this.species = species;
        this.image = image;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

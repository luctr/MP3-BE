package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sex;
    private String dateOfBirth;
    private String story;
    private String yearOfBirth;
    private String musicBand;
    private String MoreInformation ;

    public Singer(Long id, String name, String sex, String dateOfBirth, String story, String yearOfBirth, String musicBand, String moreInformation) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.story = story;
        this.yearOfBirth = yearOfBirth;
        this.musicBand = musicBand;
        MoreInformation = moreInformation;
    }

    public Singer(String name, String sex, String dateOfBirth, String story, String yearOfBirth, String musicBand, String moreInformation) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.story = story;
        this.yearOfBirth = yearOfBirth;
        this.musicBand = musicBand;
        MoreInformation = moreInformation;
    }

    public Singer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getMusicBand() {
        return musicBand;
    }

    public void setMusicBand(String musicBand) {
        this.musicBand = musicBand;
    }

    public String getMoreInformation() {
        return MoreInformation;
    }

    public void setMoreInformation(String moreInformation) {
        MoreInformation = moreInformation;
    }
}
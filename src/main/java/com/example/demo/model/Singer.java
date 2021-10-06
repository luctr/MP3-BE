package com.example.demo.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @ManyToOne
    private User user;

    public Singer() {
    }


}

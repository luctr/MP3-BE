package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity

public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private SongCategory songCategory;
    private String description;

    public Playlist(Long id, String name, Song song) {
        this.id = id;
        this.name = name;


    }

    public Playlist() {
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



    @ManyToMany
    private List<Song> song;

}

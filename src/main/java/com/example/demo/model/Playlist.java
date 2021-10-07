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
    @ManyToMany
    private List<Song> song;


    public Playlist() {
    }

    public Playlist(Long id, String name, SongCategory songCategory, String description, List<Song> song) {
        this.id = id;
        this.name = name;
        this.songCategory = songCategory;
        this.description = description;
        this.song = song;
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

    public SongCategory getSongCategory() {
        return songCategory;
    }

    public void setSongCategory(SongCategory songCategory) {
        this.songCategory = songCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }
}

package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private User user;
    @ManyToOne
    private Song song;

    public Comment(Long id, String name, User user, Song song) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.song = song;
    }

    public Comment(String name, User user, Song song) {
        this.name = name;
        this.user = user;
        this.song = song;
    }

    public Comment() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}

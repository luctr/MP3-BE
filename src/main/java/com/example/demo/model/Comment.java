package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean complete;
    @ManyToOne
    private User user;
    @ManyToOne
    private Song song;



    public Comment() {
    }

    public Comment(Long id, String name, boolean complete, User user, Song song) {
        this.id = id;
        this.name = name;
        this.complete = complete;
        this.user = user;
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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
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
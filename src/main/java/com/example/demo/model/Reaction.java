package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity

public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean status;
    @ManyToOne
    private User user;
    @ManyToOne
    private Song song;

    public Reaction() {
    }

    public Reaction(Long id, User user, Song song) {
        this.id = id;
        this.user = user;
        this.song = song;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

package com.example.demo.model;


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

    public Reaction(Boolean status, User user, Song song) {
        this.status = status;
        this.user = user;
        this.song = song;
    }

    public Reaction(Long id, Boolean status, User user, Song song) {
        this.id = id;
        this.status = status;
        this.user = user;
        this.song = song;
    }

    public Reaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
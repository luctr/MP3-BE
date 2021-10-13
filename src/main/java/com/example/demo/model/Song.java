package com.example.demo.model;


import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String mp3;
    private String avatar;
    private String author;
    private Long count;



    @ManyToOne
    private User user;
    @ManyToOne
    private SongCategory songCategory;

    @ManyToOne
    private Singer singer;

    public Song(Long id, String name, String description, String mp3, String avatar, String author, User user, SongCategory songCategory, Singer singer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mp3 = mp3;
        this.avatar = avatar;
        this.author = author;
        this.user = user;
        this.songCategory = songCategory;
        this.singer = singer;

    }

    public Song(String name, String description, String mp3, String avatar, String author, User user, SongCategory songCategory, Singer singer) {
        this.name = name;
        this.description = description;
        this.mp3 = mp3;
        this.avatar = avatar;
        this.author = author;
        this.user = user;
        this.songCategory = songCategory;
        this.singer = singer;
    }

    public Song() {
    }

    public Song(Long id, String name, String description, String mp3, String avatar, String author, Long count, User user, SongCategory songCategory, Singer singer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mp3 = mp3;
        this.avatar = avatar;
        this.author = author;
        this.count = count;
        this.user = user;
        this.songCategory = songCategory;
        this.singer = singer;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Singer getSinger() {
        return singer;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SongCategory getSongCategory() {
        return songCategory;
    }

    public void setSongCategory(SongCategory songCategory) {
        this.songCategory = songCategory;
    }



    public void setSinger(Singer singer) {
        this.singer = singer;
    }
}

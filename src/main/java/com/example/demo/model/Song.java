package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String avatar;
    private String file;
    private String description;
    private String author;
    @ManyToOne
    private SongCategory songCategory;
    @ManyToOne
    private Singer singer;
    @ManyToOne
    private User user;
    @ManyToOne
    private Reaction reaction;
    @ManyToOne
    private Comment comment;
    private Long count;


    public Song() {
    }

    public Song(Long id, String name, String avatar, String file, String description, String author, SongCategory songCategory, Singer singer, User user, Reaction reaction, Comment comment, Long count) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.file = file;
        this.description = description;
        this.author = author;
        this.songCategory = songCategory;
        this.singer = singer;
        this.user = user;
        this.reaction = reaction;
        this.comment = comment;
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public SongCategory getSongCategory() {
        return songCategory;
    }

    public void setSongCategory(SongCategory songCategory) {
        this.songCategory = songCategory;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}

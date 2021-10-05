package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @ManyToMany
    private  List<Singer>singers;
    @ManyToOne
    private User user;
    @ManyToOne
    private SongCategory songCategory;
    @ManyToOne
    private Reaction reaction;
    @ManyToOne
    private Album album;



}

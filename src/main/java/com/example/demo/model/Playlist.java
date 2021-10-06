package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private SongCategory songCategory;
    private String description;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Song> song;
}

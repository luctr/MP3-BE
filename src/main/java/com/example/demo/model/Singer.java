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
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sex;
    private String dateOfBirth;
    private String story;
    private String yearOfBirth;
    private String musicBand;
    @OneToMany
    private List<Song>songs;
    private String MoreInformation ;
    @ManyToOne
    private User user;

}

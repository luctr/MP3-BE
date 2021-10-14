package com.example.demo.service.song;

import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import com.example.demo.service.Generic;

import java.util.List;


public interface ISongService extends Generic<Song> {
    Iterable<Song> findTop4New();

    List<Song> getSongByName(String name);
    List<Song> topSong();

    List<Song> findAllByNameContaining(String name);
    List<Song> findAllByUser_Id(Long id);
}

package com.example.demo.service.playlist;

import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import com.example.demo.service.Generic;

import java.util.List;

public interface IPlaylistService extends Generic<Playlist> {
    List<Playlist> findTopById(Long id);
    List<Playlist> findAllByNameContaining(String name);
//    List<Song>findAllSongByPlayList(Long id);
}

package com.example.demo.service.playlist;

import com.example.demo.model.Playlist;
import com.example.demo.service.Generic;

import java.util.List;

public interface IPlaylistService extends Generic<Playlist> {
    List<Playlist> findTop6ByOrderByNameAsc();

    List<Playlist> findByNameContaining(String name);
}

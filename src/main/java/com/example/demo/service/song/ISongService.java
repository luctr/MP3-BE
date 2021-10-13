package com.example.demo.service.song;

import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import com.example.demo.service.Generic;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISongService extends Generic<Song> {
    Iterable<Song> findTop6New();
    List<Song> findAllByNameContaining(String name);
}

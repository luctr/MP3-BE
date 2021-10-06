package com.example.demo.service.song;

import com.example.demo.model.Song;
import com.example.demo.service.Generic;

import java.util.List;


public interface ISongService extends Generic<Song> {
    List<Song> getSongByName(String name);
}

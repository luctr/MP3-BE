package com.example.demo.service.song;

import com.example.demo.model.Song;
import com.example.demo.service.Generic;

public interface ISongService extends Generic<Song> {
    Iterable<Song> findTop4New();
}

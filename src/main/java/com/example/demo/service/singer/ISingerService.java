package com.example.demo.service.singer;

import com.example.demo.model.Singer;
import com.example.demo.model.Song;
import com.example.demo.service.Generic;

import java.util.List;

public interface ISingerService extends Generic<Singer> {
    List<Singer> getSingerByName(String name);

}

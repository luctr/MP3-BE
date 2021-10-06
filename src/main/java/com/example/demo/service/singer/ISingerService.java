package com.example.demo.service.singer;

import com.example.demo.model.Singer;
import com.example.demo.service.Generic;

public interface ISingerService extends Generic<Singer> {
    Iterable<Singer> findAllByUser_Id(Long id);
}

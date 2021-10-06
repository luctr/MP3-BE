package com.example.demo.controller;

import com.example.demo.model.Singer;
import com.example.demo.service.singer.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/singer")
public class SingerControlller {
    @Autowired
    private SingerService singerService;

    @GetMapping
    public ResponseEntity<Iterable<Singer>> findAllSinger() {
        List<Singer> singers = (List<Singer>) singerService.findAll();
        if (singers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(singers, HttpStatus.OK);
    }

    @GetMapping("/keyword")
    public ResponseEntity<List<Singer>> getSingerByName(String name) {
        List<Singer> singers =  singerService.getSingerByName(name);
        if(singers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(singerService.getSingerByName(name),HttpStatus.OK);
    }
}

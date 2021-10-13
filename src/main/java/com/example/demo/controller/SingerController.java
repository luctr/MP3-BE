package com.example.demo.controller;

import com.example.demo.model.Singer;


import com.example.demo.model.Song;

import com.example.demo.service.singer.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/singer")
@CrossOrigin("*")
public class SingerController {
    @Autowired
    private ISingerService singerService;

    @GetMapping
    public ResponseEntity<Iterable<Singer>> findAll() {
        Iterable<Singer> singerIterable = singerService.findAll();
        return new ResponseEntity<>(singerIterable, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Singer> findById(@PathVariable Long id) {
        Optional<Singer> singerOptional = singerService.findById(id);
        if (!singerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(singerOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Singer> save(@RequestBody Singer singer) {
        singerService.save(singer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")



    public ResponseEntity<Singer> editSinger(@PathVariable Long id, @RequestBody Singer singer) {
        Optional<Singer> singerOptional = singerService.findById(id);
        if (!singerOptional.isPresent()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        singer.setId(id);
        singerService.save(singer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")


    public ResponseEntity<Singer> deleteById(@PathVariable Long id) {
        Optional<Singer> singerOptional = singerService.findById(id);
        if (!singerOptional.isPresent()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        singerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Singer>> findAllSinger() {
        List<Singer> singers = (List<Singer>) singerService.findAll();
        if (singers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(singers, HttpStatus.OK);
    }
//tìm tên ca sĩ
    @GetMapping("/keyword")
    public ResponseEntity<List<Singer>> getSingerByName(String name) {
        List<Singer> singers =  singerService.getSingerByName(name);
        if(singers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(singerService.getSingerByName(name),HttpStatus.OK);
    }
//tìm danh sách bài hát theo ca sĩ
    @GetMapping("/showSongs")
    public ResponseEntity<List<Singer>> findSongBySinger(String name) {
        List<Singer> singers =  singerService.getSingerByName(name);
        if(singers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(singerService.getSingerByName(name),HttpStatus.OK);
    }


    @GetMapping("/search/{name}")
    public ResponseEntity<List<Singer>> findAllByName(@PathVariable("name") String name) {
        List<Singer> singerList = singerService.findAllByNameContaining(name);
        return new ResponseEntity<>(singerList, HttpStatus.OK);
    }

    @GetMapping("/top7")
    public ResponseEntity<Iterable<Singer>> findTop7New() {
        Iterable<Singer> songIterable = singerService.findTop7New();
        return new ResponseEntity<>(songIterable, HttpStatus.OK);
    }

}


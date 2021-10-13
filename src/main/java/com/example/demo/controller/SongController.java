package com.example.demo.controller;

import com.example.demo.model.Song;

import com.example.demo.service.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;


    @GetMapping
    public ResponseEntity<Iterable<Song>> findAllSongs() {
        List<Song> songs = (List<Song>) songService.findAll();
        if (songs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping

    public ResponseEntity<Song> saveSongs(@RequestBody Song song) {
        songService.save(song);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Song> deleteSongs(@PathVariable Long id) {
        Optional<Song> songOptional = songService.findById(id);
        if (!songOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        songService.delete(id);
        return new ResponseEntity<>(songOptional.get(), HttpStatus.NO_CONTENT);
    }


    @PutMapping("edit/{id}")
    public ResponseEntity<Song> editUser(@PathVariable Long id, @RequestBody Song song){
        Optional< Song> songOptional = songService.findById(id);
        if(!songOptional.isPresent()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        song.setId(id);
        songService.save(song);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> findSongById(@PathVariable Long id) {
        Optional<Song> customerOptional = songService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }


    @GetMapping("/songs/keyword")
    public ResponseEntity<List<Song>> getSongByName(@RequestParam String name) {
        return new ResponseEntity<>(songService.getSongByName(name),HttpStatus.OK);

    }

    @GetMapping("/topsong")
    public ResponseEntity<List<Song>> getTopSong() {
        List<Song> songs =  songService.topSong();
        if (songs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }


    @GetMapping("/top4")
    public ResponseEntity<Iterable<Song>> findTop4New() {
        Iterable<Song> songIterable = songService.findTop4New();
        return new ResponseEntity<>(songIterable, HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Song>> findAllByName(@PathVariable("name") String name) {
        List<Song> songList = songService.findAllByNameContaining(name);
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }



}

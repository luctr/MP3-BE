package com.example.demo.controller;


import com.example.demo.model.Song;
import com.example.demo.service.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<Iterable<Song>> findAll() {
        Iterable<Song> songs = songService.findAll();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createNewSongs(@RequestBody Song song) {
        songService.save(song);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Song> deleteById(@PathVariable Long id) {
        Optional<Song> songOptional = songService.findById(id);
        if (!songOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        songService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Song> editUser(@PathVariable Long id, @RequestBody Song song){
        Optional< Song> songOptional = songService.findById(id);
        if(!songOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        songService.save(song);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> findById(@PathVariable Long id) {
        Optional<Song> songOptional = songService.findById(id);
        if (!songOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/top4")
    public ResponseEntity<Iterable<Song>> findTop4New() {
        Iterable<Song> songIterable = songService.findTop4New();
        return new ResponseEntity<>(songIterable, HttpStatus.OK);
    }

}

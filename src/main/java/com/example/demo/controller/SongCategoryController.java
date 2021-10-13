package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.model.SongCategory;
import com.example.demo.service.song.SongService;
import com.example.demo.service.songcategory.SongCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/songCategories")
public class SongCategoryController {
    @Autowired
    private SongCategoryService songCategoryService;

    @GetMapping
    public ResponseEntity<Iterable<SongCategory>> findAll() {
        Iterable<SongCategory> songCategories = songCategoryService.findAll();
        return new ResponseEntity<>(songCategories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createNewSongCategory(@RequestBody SongCategory songCategory) {
        songCategoryService.save(songCategory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Song> deleteById(@PathVariable Long id) {
        Optional<SongCategory> songCategoryServiceOptional = songCategoryService.findById(id);
        if (!songCategoryServiceOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        songCategoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Song> editSongCategory(@PathVariable Long id, @RequestBody SongCategory songCategory){
        Optional< SongCategory> songCategoryOptional = songCategoryService.findById(id);
        if(!songCategoryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        songCategoryService.save(songCategory);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> findById(@PathVariable Long id) {
        Optional<SongCategory> songCategoryOptional = songCategoryService.findById(id);
        if (!songCategoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }songCategoryOptional.get();
        return new ResponseEntity<>( HttpStatus.OK);
    }
}

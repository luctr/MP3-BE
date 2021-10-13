package com.example.demo.controller;

import com.example.demo.model.Playlist;
import com.example.demo.model.User;
import com.example.demo.service.playlist.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<Iterable<Playlist>> findAll() {
        Iterable<Playlist> playlists = playlistService.findAll();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Playlist> createNewSongs(@RequestBody Playlist playlist) {
        playlistService.save(playlist);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Playlist> PlaylistByID(@PathVariable Long id) {
        Playlist playList1 = playlistService.findById(id).get();
        if (playList1 != null) {
            return new ResponseEntity<>(playList1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> deleteById(@PathVariable Long id) {
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if (!playlistOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playlistService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Playlist> editUser(@PathVariable Long id, @RequestBody Playlist playlist){
        Optional< Playlist> playlistOptional = playlistService.findById(id);
        if(!playlistOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playlistService.save(playlist);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> findById(@PathVariable Long id) {
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if (!playlistOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playlistOptional.get(), HttpStatus.OK);
    }

    // tim kiem playlist theo ten




    @GetMapping("/search")
    private ResponseEntity<List<Playlist>> findPlaylistByName(@RequestParam("name") String name){
        List<Playlist> playLists = playlistService.findByNameContaining(name);
        return new ResponseEntity<>(playLists,HttpStatus.OK);
    }
    @GetMapping("/topName")
    public ResponseEntity<List<Playlist>> topName() {
        List<Playlist> playListName = playlistService.findTop6ByOrderByNameAsc();

        if (playListName != null) {
            return new ResponseEntity<>(playListName, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
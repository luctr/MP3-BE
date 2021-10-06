package com.example.demo.controller;

import com.example.demo.model.Singer;
import com.example.demo.service.singer.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/singer")
@CrossOrigin("*")
public class SingerController {
    @Autowired
    private ISingerService singerService;
    @GetMapping
    public ResponseEntity<Iterable<Singer>> findAll(){
        Iterable<Singer> singerIterable= singerService.findAll();
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
    public ResponseEntity<Singer> editSinger(@PathVariable Long id, @RequestBody Singer singer){
        Optional< Singer> singerOptional = singerService.findById(id);
        if(!singerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        singer.setId(id);
        singerService.save(singer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Singer> deleteById(@PathVariable Long id){
        Optional<Singer> singerOptional = singerService.findById(id);
        if(!singerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        singerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


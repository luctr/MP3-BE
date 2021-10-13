package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.model.Song;
import com.example.demo.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<Iterable<Comment>> findAllComment() {
        List<Comment> comments = (List<Comment>) commentService.findAll();
        if (comments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Song> saveComment(@RequestBody Comment comment) {
        commentService.save(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Song> deleteComment(@PathVariable Long id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentService.delete(id);
        commentOptional.get();
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> findCommentById(@PathVariable Long id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentOptional.get();
        return new ResponseEntity<>( HttpStatus.OK);
    }
}

package com.example.demo.service.song;

import com.example.demo.model.Song;
import com.example.demo.model.User;
import com.example.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SongService implements ISongService{
    @Autowired
    private SongRepository songRepository;

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public User save(Song song) {
        songRepository.save(song);
        return null;
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }
}

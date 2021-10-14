package com.example.demo.service.song;

import com.example.demo.model.Song;
import com.example.demo.model.User;
import com.example.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }

    public Iterable<Song> findTop6New() {
        return songRepository.findTop6New();
    }

    @Override
    public Iterable<Song> findTop4New() {
        return null;
    }

    @Override
    public List<Song> getSongByName(String name) {
        return null;
    }

    @Override
    public List<Song> topSong() {
        return songRepository.topSong();
    }

    @Override
    public List<Song> findAllByNameContaining(String name) {
        return songRepository.findAllByNameContaining(name);
    }

    @Override
    public List<Song> findAllByUser_Id(Long id) {
        return songRepository.findAllByUser_Id(id);
    }
}

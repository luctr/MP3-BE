package com.example.demo.service.playlist;

import com.example.demo.model.Playlist;
import com.example.demo.model.User;
import com.example.demo.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PlaylistService implements IPlaylistService{
    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Iterable<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public User save(Playlist playlist) {

        return null;
    }

    @Override
    public void delete(Long id) {
        playlistRepository.deleteById(id);
    }
}

package com.example.demo.service.playlist;

import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import com.example.demo.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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
    public void save(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    @Override
    public void delete(Long id) {
        playlistRepository.deleteById(id);
    }

    @Override
    public List<Playlist> findTopById(Long id) {
        return playlistRepository.findTopById(id);
    }

    @Override
    public List<Playlist> findAllByNameContaining(String name) {
        return playlistRepository.findAllByNameContaining(name);
    }

//    @Override
//    public List<Song> findAllSongByPlayList(Long id) {
//        return playlistRepository.findAllSongByPlayList(id);
//    }
}

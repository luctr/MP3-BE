package com.example.demo.service.playlist;

import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import com.example.demo.repository.PlaylistRepository;
import com.example.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlaylistService implements IPlaylistService{
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private SongRepository songRepository;




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
    public List<Playlist> findTop6ByOrderByNameAsc() {
        return playlistRepository.findTop6ByOrderByNameAsc();
    }

    @Override
    public List<Playlist> findByNameContaining(String name) {
        return playlistRepository.findByNameContaining(name);
    }
    public void addSongToPlaylist(long idPlaylist, long idSong){
        Playlist playlist = playlistRepository.findById(idPlaylist).get();
        Song song = songRepository.getById(idSong);
        playlist.getSong().add(song);
        playlistRepository.save(playlist);
    }
}

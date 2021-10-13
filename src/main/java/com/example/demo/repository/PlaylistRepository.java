package com.example.demo.repository;

import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
    List<Playlist> findTopById(Long id);
    List<Playlist> findAllByNameContaining(String name);
//    @Query(value="SELECT song.* from song JOIN playlist_song on song.id = playlist_song.song_id where playlist_song.playlist_id=:id", nativeQuery = true)
//    List<Song>findAllSongByPlayList(@Param("id") Long id);
}

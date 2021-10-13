package com.example.demo.repository;


import com.example.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {
    List<Song> findByNameContaining(String keywords);
    @Query(" SELECT c FROM Song c ORDER BY c.count DESC")
    List<Song> topSong();
}

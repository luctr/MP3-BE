package com.example.demo.repository;

import com.example.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    @Modifying
    @Query(value = "select * from song order by id desc limit 6", nativeQuery = true)
    Iterable<Song> findTop6New();
    List<Song> findAllByNameContaining(String name);
    @Query(" SELECT c FROM Song c ORDER BY c.count DESC")
    List<Song> topSong();    List<Song> findByNameContaining(String keywords);
}

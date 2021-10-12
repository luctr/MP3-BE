package com.example.demo.repository;

import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface SongRepository extends JpaRepository<Song, Long> {


import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    @Modifying
    @Query(value = "select * from song order by id desc limit 4", nativeQuery = true)
    Iterable<Song> findTop4New();
    List<Song> findAllByNameContaining(String name);

}

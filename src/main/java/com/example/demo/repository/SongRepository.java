package com.example.demo.repository;

import com.example.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {
    @Modifying
    @Query(value = "select * from song order by id desc limit 4", nativeQuery = true)
    Iterable<Song> findTop4New();
}

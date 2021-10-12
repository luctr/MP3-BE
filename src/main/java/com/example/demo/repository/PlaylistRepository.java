package com.example.demo.repository;

import com.example.demo.model.Playlist;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Long> {

    List<Playlist> findTopById(Long id);

    List<Playlist> findAllByNameContaining(String name);

    List<Playlist> findTop6ByOrderByNameAsc();

    List<Playlist> findByNameContaining(String name);



}

package com.example.demo.repository;

import com.example.demo.model.Reaction;
import com.example.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction,Long> {
}

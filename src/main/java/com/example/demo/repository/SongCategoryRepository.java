package com.example.demo.repository;

import com.example.demo.model.SongCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongCategoryRepository extends JpaRepository<SongCategory,Long> {
}

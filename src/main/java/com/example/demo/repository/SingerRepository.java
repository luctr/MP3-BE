package com.example.demo.repository;
import com.example.demo.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerRepository extends JpaRepository<Singer,Long> {
    List<Singer> findAllByNameContaining(String name);
}

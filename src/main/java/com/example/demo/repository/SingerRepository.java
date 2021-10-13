package com.example.demo.repository;
import com.example.demo.model.Singer;
import com.example.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerRepository extends JpaRepository<Singer,Long> {

    List<Singer> findByName(String keyword);

    List<Singer> findAllByNameContaining(String name);
    @Query(value = "select * from singer order by id desc limit 7", nativeQuery = true)
    Iterable<Singer> findTop7New();
}

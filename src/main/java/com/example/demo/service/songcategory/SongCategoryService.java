package com.example.demo.service.songcategory;

import com.example.demo.model.SongCategory;
import com.example.demo.model.User;
import com.example.demo.repository.SongCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SongCategoryService implements ISongCategoryService {
    @Autowired
    private SongCategoryRepository songCategoryRepository;

    @Override
    public Iterable<SongCategory> findAll() {
        return songCategoryRepository.findAll();
    }

    @Override
    public Optional<SongCategory> findById(Long id) {
        return songCategoryRepository.findById(id);
    }

    @Override
    public void save(SongCategory songCategory) {
        songCategoryRepository.save(songCategory);
    }

    @Override
    public void delete(Long id) {
        songCategoryRepository.deleteById(id);
    }
}
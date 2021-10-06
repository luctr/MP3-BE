package com.example.demo.service.singer;

import com.example.demo.model.Comment;
import com.example.demo.model.Singer;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SingerService implements ISingerService{
    @Autowired
    private SingerRepository singerRepository;

    @Override
    public Iterable<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public Optional<Singer> findById(Long id) {
        return singerRepository.findById(id);
    }

    @Override
    public void save(Singer singer) {
        singerRepository.save(singer);
    }

    @Override
    public void delete(Long id) {
        singerRepository.deleteById(id);
    }

    @Override
    public List<Singer> getSingerByName(String name) {
        return singerRepository.findByName(name);
    }
}

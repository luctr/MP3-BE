package com.example.demo.service.singer;

import com.example.demo.model.Singer;
import com.example.demo.model.User;
import com.example.demo.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User save(Singer singer) {
        singerRepository.save(singer);
        return null;
    }

    @Override
    public void delete(Long id) {
        singerRepository.deleteById(id);
    }
}

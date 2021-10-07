package com.example.demo.service.reaction;

import com.example.demo.model.Reaction;
import com.example.demo.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ReactionService implements IReactionService {
    @Autowired
    private ReactionRepository reactionRepository;

    @Override
    public Iterable<Reaction> findAll() {
        return reactionRepository.findAll();
    }

    @Override
    public Optional<Reaction> findById(Long id) {
        return reactionRepository.findById(id);
    }

    @Override
    public void save(Reaction reaction) {
        reactionRepository.save(reaction);
    }

    @Override
    public void delete(Long id) {
        reactionRepository.deleteById(id);
    }
}

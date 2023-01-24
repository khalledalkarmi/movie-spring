package com.kh.moviespring.service;

import com.kh.moviespring.model.Movies;
import com.kh.moviespring.repository.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;

    public List<Movies> getAllMovie() {
        return movieRepo.findAll();
    }

    public Optional<Movies> getMovieByID(ObjectId id) {
        return movieRepo.findById(id);
    }

    public Optional<Movies> getMovieByImdbID(String id) {
        return movieRepo.findMoviesByImdbId(id);
    }
}

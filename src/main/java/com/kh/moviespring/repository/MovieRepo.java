package com.kh.moviespring.repository;

import com.kh.moviespring.model.Movies;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepo extends MongoRepository<Movies, ObjectId> {
    Optional<Movies> findById(ObjectId id);

    List<Movies> findAll();

    Optional<Movies> findMoviesByImdbId(String id);
}

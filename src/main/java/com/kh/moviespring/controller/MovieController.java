package com.kh.moviespring.controller;

import com.kh.moviespring.model.Movies;
import com.kh.moviespring.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movies>> all() {
        return new ResponseEntity<List<Movies>>(movieService.getAllMovie(), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Optional<Movies>> getMovieByID(@RequestParam ObjectId id) {
        return new ResponseEntity<>(movieService.getMovieByID(id), HttpStatus.OK);
    }

    @GetMapping(value = "/find" ,params = {"imdb"})
    public ResponseEntity<Optional<Movies>> getMovieByID(@RequestParam String imdb) {
        return new ResponseEntity<>(movieService.getMovieByImdbID(imdb), HttpStatus.OK);
    }

}

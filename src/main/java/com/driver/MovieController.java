package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie added succesfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Director added succesfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){
        Movie movie = movieService.findMovie(movieName);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{directorName}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String directorName){
        Director director = movieService.findDirector(directorName);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName ,@RequestParam String directorName){
        movieService.mapMovieByDirector(movieName,directorName);
        return new ResponseEntity<>("Movie-Director Pair created succesfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{directorName}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String directorName){
        List<String> movieList=movieService.findMoviesOfDirector(directorName);
        return new ResponseEntity<>(movieList,HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> getAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name/{directorName}")
    public ResponseEntity<String> deleteDirectorByName(@PathVariable String directorName){
        movieService.deleteDirector(directorName);
        return new ResponseEntity<>("Director deleted succesfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirector();
        return new ResponseEntity<>("Deleted All Directors Succesfully",HttpStatus.CREATED);
    }
}

package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }


    public Movie findMovie(String movieName){
        return movieRepository.findMovie(movieName);
    }

    public Director findDirector(String directorName){
        return movieRepository.findDirector(directorName);
    }

    public void mapMovieByDirector(String movie, String director){
        movieRepository.mapMovieByDirector(movie, director);
    }

    public List<String> findMoviesOfDirector(String director){
        return movieRepository.findMoviesOfDirector(director);
    }

    public List<String> allMovies(){
        return movieRepository.allMovies();
    }

    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }

    public void deleteAllDirector(){
        movieRepository.deleteAllDirector();
    }
}

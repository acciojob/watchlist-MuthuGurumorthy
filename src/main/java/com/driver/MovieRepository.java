package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieHashMap;
    private HashMap<String,Director> directorHashMap;
    private HashMap<String, List<String>> movieDirectorMap;

    public MovieRepository(HashMap<String, Movie> movieHashMap, HashMap<String, Director> directorHashMap, HashMap<String, List<String>> movieDirectorMap) {
        this.movieHashMap = new HashMap<String,Movie>();
        this.directorHashMap = new HashMap<String,Director>();
        this.movieDirectorMap = new HashMap<String,List<String>>();
    }

    public void addMovie(Movie movie){
        movieHashMap.put(movie.getName(),movie);
    }

    public void addDirector(Director director){
        directorHashMap.put(director.getName(),director);
    }

    public Movie findMovie(String movie){
        return movieHashMap.get(movie);
    }

    public Director findDirector(String director){
        return directorHashMap.get(director);
    }

    public void mapMovieByDirector(String movie, String director){
        if(movieHashMap.containsKey(movie) && directorHashMap.containsKey(director)){
            List<String> newMovies = new ArrayList<>();
            if(movieDirectorMap.containsKey(director)) newMovies = movieDirectorMap.get(director);
            newMovies.add(movie);
            movieDirectorMap.put(director, newMovies);
        }
    }

    public List<String> findMoviesOfDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(movieDirectorMap.containsKey(director)) moviesList = movieDirectorMap.get(director);
        return moviesList;
    }

    public List<String> allMovies(){
        return new ArrayList<>(movieHashMap.keySet());
    }

    public void deleteDirector(String director){
        List<String> movies = new ArrayList<String>();
        if(movieDirectorMap.containsKey(director)){
            movies = movieDirectorMap.get(director);
            for(String movie: movies){
                if(movieHashMap.containsKey(movie)){
                    movieHashMap.remove(movie);
                }
            }

            movieDirectorMap.remove(director);
        }

        if(directorHashMap.containsKey(director)){
            directorHashMap.remove(director);
        }
    }

    public void deleteAllDirector() {
        HashSet<String> movieDirector;
        movieDirector = new HashSet<String>();

        for (String director : movieDirectorMap.keySet()) {
            for (String movie : movieDirectorMap.get(director)) {
                movieDirector.add(movie);
            }
        }

        for (String movie : movieDirector) {
            if (movieHashMap.containsKey(movie)) {
                movieHashMap.remove(movie);
            }
        }
    }
}

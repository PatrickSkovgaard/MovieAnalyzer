package com.example.movieanalyzer.demo.controllers;

import com.example.movieanalyzer.demo.models.Movie;
import com.example.movieanalyzer.demo.services.Awards;
import com.example.movieanalyzer.demo.services.MovieAnalyzerApplication;
import com.example.movieanalyzer.demo.services.MovieByPopularity;
import com.example.movieanalyzer.demo.services.RandomMovie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.util.ArrayList;

@Controller
public class MovieController {

    MovieAnalyzerApplication movieAnalyzerApplication = new MovieAnalyzerApplication();
    RandomMovie randomMovie = new RandomMovie();
    MovieByPopularity movieByPopularity = new MovieByPopularity();
    Awards awards = new Awards();

    @ResponseBody
    @GetMapping("/")
    public String firstMessage(){
        return "Hello there. Welcome to the site, where you can get the first movie from the list," +
                "get a random movie, get the ten most popular movies, or see how many movies have awards.";

    }


    @ResponseBody
    @GetMapping("FirstMovie")
    public String getFirstMovie(){
        try {
            Movie firstMovie = movieAnalyzerApplication.getFirstMovieOfList();
            return firstMovie.getTitle();
        }
        catch (FileNotFoundException f){
            return "File not found.";
        }
    }

    @ResponseBody
    @GetMapping("RandomMovie")
    public String getRandomMovie() throws FileNotFoundException {
        Movie randomMovieFromList = randomMovie.getRandomMovie();
        return randomMovieFromList.getTitle();
    }


    @ResponseBody
    @GetMapping("TenMostPopular")
    public ArrayList<String> getMostPopularMovies() throws FileNotFoundException {
        ArrayList<Movie> arrayWithMovies = movieByPopularity.tenMostPopularMovies();
        ArrayList<String> arrayToBrowser = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            arrayToBrowser.add("| Title: " + arrayWithMovies.get(i).getTitle() + "; Popularity rating: " + arrayWithMovies.get(i).getPopularity() + " |    ");
        }
        return arrayToBrowser;
    }


    @ResponseBody
    @GetMapping("Awards")
    public int howManyMoviesHaveAwards() throws FileNotFoundException {
        return awards.howManyMoviesHaveAwards();
    }
}

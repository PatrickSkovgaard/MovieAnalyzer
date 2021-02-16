package com.example.movieanalyzer.demo.services;

import com.example.movieanalyzer.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieAnalyzerApplication {

    public Movie getFirstMovieOfList () throws FileNotFoundException {

        File movieList = new File("src/main/resources/static/film-new.csv");
        Scanner in = new Scanner(movieList);

        in.nextLine();
        in.nextLine();

        String [] movieListAsArray = in.nextLine().split(";");

        return new Movie(movieListAsArray[0], movieListAsArray[1], movieListAsArray[2]);
    }
}

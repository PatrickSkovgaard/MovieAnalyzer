package com.example.movieanalyzer.demo.services;

import com.example.movieanalyzer.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomMovie {

    Random random = new Random((6)+1);
    ArrayList<Movie> movieArray = new ArrayList<>();
    int count = 0;

    public Movie getRandomMovie() throws FileNotFoundException {

        File movieList = new File("src/main/resources/static/film-new.csv");
        Scanner in = new Scanner(movieList);

        in.nextLine();
        in.nextLine();

        while (in.hasNextLine()) {
            String [] moviesSplit = in.nextLine().split(";");
            Movie randomMovie = new Movie(moviesSplit[0], moviesSplit[1], moviesSplit[2]);

            movieArray.add(randomMovie);
            count++;
        }
        return movieArray.get(random.nextInt(count)+1);
    }
}

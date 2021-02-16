package com.example.movieanalyzer.demo.services;

import com.example.movieanalyzer.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Awards {

    int count = 0;
    String movie;
    ArrayList<String> movieAwards = new ArrayList<>();

    public int howManyMoviesHaveAwards() throws FileNotFoundException {

        File movieList = new File("src/main/resources/static/film-new.csv");
        Scanner in = new Scanner(movieList);

        in.nextLine();
        in.nextLine();

        while (in.hasNextLine()) {
            String[] moviesSplit = in.nextLine().split(";");
            movie = (moviesSplit[5]);
            movieAwards.add(movie);
        }
        for (int i = 0; i < movieAwards.size(); i++){
            if (movieAwards.get(i).equalsIgnoreCase("yes")){
                count++;
            }
        }
        return count;
    }
}

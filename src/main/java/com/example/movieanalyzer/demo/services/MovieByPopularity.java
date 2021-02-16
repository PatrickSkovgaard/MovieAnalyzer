package com.example.movieanalyzer.demo.services;

import com.example.movieanalyzer.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class MovieByPopularity {

    private ArrayList<Movie> arrayWithMovies = new ArrayList<>();
    private ArrayList<Movie> arrayWithTenRandomMovies = new ArrayList<>();
    private Random random = new Random();
    private int count = 0;

    public ArrayList<Movie> tenMostPopularMovies() throws FileNotFoundException {

        File movieList = new File("src/main/resources/static/film-new.csv");
        Scanner in = new Scanner(movieList);

        in.nextLine();
        in.nextLine();


        while (in.hasNextLine()){
            String [] moviesSplit = in.nextLine().split(";");
            Movie movie = new Movie(moviesSplit[2], Integer.parseInt(moviesSplit[4]));


            arrayWithMovies.add(movie);
            count++;
            }

        for (int i = 0; i < 10; i++){
            arrayWithTenRandomMovies.add(arrayWithMovies.get(random.nextInt(count)+1));
        }

            arrayWithTenRandomMovies.sort(Comparator.comparingInt(Movie::getPopularity).reversed());

            return arrayWithTenRandomMovies;
    }
}

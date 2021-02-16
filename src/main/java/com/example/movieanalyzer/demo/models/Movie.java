package com.example.movieanalyzer.demo.models;

public class Movie {

    private String year;
    private String length;
    private String title;
    private int popularity;
    private String award;


        public Movie (String year, String length, String title){
            this.year = year;
            this.length = length;
            this.title = title;
        }

        public Movie (String title, int popularity){
            this.title = title;
            this.popularity = popularity;
        }

        public Movie (String award){
            this.award = award;
        }

    public String getYear() {
        return year;
    }

    public String getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getAward() {
        return award;
    }


    public void setPopularity(int popularity){
        this.popularity = popularity;
    }
}

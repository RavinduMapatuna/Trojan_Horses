package com.example.mymovielist.model;

public class CategoryItem {
    int movieId;
    String movieImg;
    String movieName;
    float rating;
    String sypnosis;
    String type;
    int year;
    int length;

    public CategoryItem(){

    }

    public CategoryItem(int movieId, String movieImg) {
        this.movieId = movieId;
        this.movieImg = movieImg;
    }

    public CategoryItem(int movieId, String movieImg, String movieName, float rating, String sypnosis, String type, int year, int length) {
        this.movieId = movieId;
        this.movieImg = movieImg;
        this.movieName = movieName;
        this.rating = rating;
        this.sypnosis = sypnosis;
        this.type = type;
        this.year = year;
        this.length = length;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getSypnosis() {
        return sypnosis;
    }

    public void setSypnosis(String sypnosis) {
        this.sypnosis = sypnosis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

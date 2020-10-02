package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    String backdrop_path;
    String poster_path;
    String title;
    String overview;
    double rating;
    String releaseDate;
    boolean adult;
    int id;
    int popularity;
    int voteCount;

    public Movie() {}

    public Movie(JSONObject jsonObject) throws JSONException {
        backdrop_path = jsonObject.getString("backdrop_path");
        poster_path = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        releaseDate = jsonObject.getString("release_date");
        adult = jsonObject.getBoolean("adult");
        id = jsonObject.getInt("id");
        popularity = jsonObject.getInt("popularity");
        voteCount = jsonObject.getInt("vote_count");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i =0; i<movieJsonArray.length();i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getBackdrop_path() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdrop_path);
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", poster_path);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public boolean isAdult() {
        return adult;
    }

    public int getId() {
        return id;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }
}

package edu.uic.cs478.baginski.s2020.movies;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MovieInfoActivity extends AppCompatActivity {
    private HashMap<String, String> releaseDate = new HashMap<String, String>();
    private HashMap<String, String> duration = new HashMap<String, String>();
    private HashMap<String, String> directorName = new HashMap<String, String>();
    private HashMap<String, String> actors = new HashMap<String, String>();
    private HashMap<String, String> rating1 = new HashMap<String, String>();  // uses IMDb rating
    private HashMap<String, String> rating2 = new HashMap<String, String>();  // uses rotten tomatoes rating

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_info);

        initData();

        // get the movie name from the calling activity and set up the title
        Intent i = getIntent();
        final String movieName = i.getStringExtra("title");
        setTitle(movieName);

        // attach View resources to variables
        TextView date = (TextView) findViewById(R.id.release_date);
        TextView movieDuration = (TextView) findViewById(R.id.duration);
        TextView director = (TextView) findViewById(R.id.director);
        TextView actorNames = (TextView) findViewById(R.id.actors);
        TextView rating1Text = (TextView) findViewById(R.id.rating1);
        TextView rating2Text = (TextView) findViewById(R.id.rating2);

        // update the text fields to the correct info for the movie
        date.setText("Relase Date: " + releaseDate.get(movieName));
        movieDuration.setText("Duration: " + duration.get(movieName));
        director.setText("Director: " + directorName.get(movieName));
        actorNames.setText("Actors: " + actors.get(movieName));
        rating1Text.setText("IMDb Rating: " + rating1.get(movieName));
        rating2Text.setText("Rotten Tomatoes Rating: " + rating2.get(movieName));
    }

    // initializes all of the hashmaps to map movie names to string values
    public void initData() {
        // map the movie titles to their release dates
        releaseDate.put("Avengers", "April 26, 2019");
        releaseDate.put("A Quiet Place", "April 6, 2018");
        releaseDate.put("Black Panther", "February 16, 2018");
        releaseDate.put("Deadpool", "February 12, 2016");
        releaseDate.put("Get Out", "February 24, 2017");
        releaseDate.put("Sicario", "October 2, 2015");

        // map movie titles to their durations
        duration.put("Avengers", "2h 23min");
        duration.put("A Quiet Place", "1h 31min");
        duration.put("Black Panther", "2h 15min");
        duration.put("Deadpool", "1h 49min");
        duration.put("Get Out", "1h 44min");
        duration.put("Sicario", "2h 1min");

        // map movie titles to their directors
        directorName.put("Avengers", "Anthony Russo, Joe Russo");
        directorName.put("A Quiet Place", "John Krasinski");
        directorName.put("Black Panther", "Ryan Coogler");
        directorName.put("Deadpool", "Tim Miller");
        directorName.put("Get Out", "Jordan Peele");
        directorName.put("Sicario", "Dennis Villeneuve");

        // map movie titles to their directors
        actors.put("Avengers", "Robert Downey Jr., Chris Evans, Mark Ruffalo, Scarlett Johansson");
        actors.put("A Quiet Place", "John Krasinski, Emily Blunt, Millicent Simmonds");
        actors.put("Black Panther", "Chadwick Boseman, Michael B. Jordan, Lupita Nyong'o");
        actors.put("Deadpool", "Ryan Reynolds, Morena Baccarin, T.J. Miller");
        actors.put("Get Out", "Daniel Kaluuya, Allison Williams, Catherine Keener");
        actors.put("Sicario", "Benicio del Toro, Emily Blunt, Josh Brolin");

        // map movie titles to their IMDb ratings
        rating1.put("Avengers", "8.5/10");
        rating1.put("A Quiet Place", "7.5/10");
        rating1.put("Black Panther", "7.3/10");
        rating1.put("Deadpool", "8/10");
        rating1.put("Get Out", "7.7/10");
        rating1.put("Sicario", "7.6/10");

        // map movie titles to their Rotten Tomatoes Ratings
        rating2.put("Avengers", "92%");
        rating2.put("A Quiet Place", "95%");
        rating2.put("Black Panther", "97%");
        rating2.put("Deadpool", "85%");
        rating2.put("Get Out", "98%");
        rating2.put("Sicario", "92%");

    }
}

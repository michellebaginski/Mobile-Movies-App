package edu.uic.cs478.baginski.s2020.movies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieActivity extends AppCompatActivity {
    TextView movieTitle;
    ImageView moviePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_view);
        setTitle("Movie Information");

        movieTitle = findViewById(R.id.title);
        moviePoster = findViewById(R.id.movie_poster);

        Intent intent = getIntent();
        final String getName =  intent.getStringExtra("title");
        final int getImage = intent.getIntExtra("poster",0);

        movieTitle.setText(getName);
        moviePoster.setImageResource(getImage);

        RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(2000, 2000);
        moviePoster.setLayoutParams(layout);

        // clicking on the image will launch a website to the imdb for that movie
        moviePoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrowser(getName);
            }
        });
    }

    // matches a movie name sent from the previous activity with the corresponding imdb page & launches website
    public void openBrowser(String movieName) {
        String website = "";

        // match the movie with the website, save in a string
        switch (movieName) {
            case "A Quiet Place":
                website = "https://www.imdb.com/title/tt6644200/";
                break;
            case "Avengers":
                website = "https://www.imdb.com/title/tt4154796/";
                break;
            case "Get Out":
                website = "https://www.imdb.com/title/tt5052448/";
                break;
            case "Sicario":
                website = "https://www.imdb.com/title/tt3397884/";
                break;
            case "Black Panther":
                website = "https://www.imdb.com/title/tt1825683/";
            case "Deadpool":
                website = "https://www.imdb.com/title/tt5463162/";
                break;
            default:
                website = "https://www.imdb.com";
        }

        Intent imdbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(imdbIntent);
    }
}

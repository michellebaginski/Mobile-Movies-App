package edu.uic.cs478.baginski.s2020.movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/* This class extends ListActivity, so by default it has an attached ListView as its layout */
public class MainActivity extends ListActivity {
    private String[] movieNames = {"Avengers", "A Quiet Place", "Black Panther", "Deadpool", "Get Out", "Sicario"};
    private String[] releaseDates = {"2019", "2018", "2018", "2016", "2017", "2015"};
    private int[] imageIDs = {R.drawable.avengers, R.drawable.a_quiet_place, R.drawable.black_panther, R.drawable.deadpool, R.drawable.get_out, R.drawable.sicario};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // retrieve the ListView
        listView = getListView();

        // create a custom adapter that will populate the layouts of the individual views
        MovieListAdapter adapter = new MovieListAdapter(movieNames, releaseDates, imageIDs, this);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent movieInfoIntent = new Intent(MainActivity.this, MovieActivity.class);
                movieInfoIntent.putExtra("title", movieNames[position]);
                movieInfoIntent.putExtra("poster", imageIDs[position]);

                startActivity(movieInfoIntent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.long_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo ad = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        // this determines which view in the ListView was clicked
        int clickPos = ad.position;

        switch (item.getItemId()) {
            case R.id.info:
                openInfoActivity(clickPos);
                break;
            case R.id.imdb:
                openMenuItem(getIMDb(clickPos));
                break;
            case R.id.wiki:
                openMenuItem(getWiki(clickPos));
                break;
            case R.id.trailer:
                openMenuItem(getTrailer(clickPos));
                break;
            default:
                break;
        }

        return true;
    }


    // matches the position of the ListView click to the youtube movie trailer
    public String getTrailer(int position) {
        String website = "";

        switch (position) {
            case 0:  // avengers
                website = "https://www.youtube.com/watch?v=TcMBFSGVi1c";
                break;
            case 1: // a quiet place
                website = "https://www.youtube.com/watch?v=XEMwSdne6UE";
                break;
            case 2: // black panther
                website = "https://www.youtube.com/watch?v=xjDjIWPwcPU";
                break;
            case 3: // deadpool
                website = "https://www.youtube.com/watch?v=gtTfd6tISfw";
                break;
            case 4: // get out
                website = "https://www.youtube.com/watch?v=DzfpyUB60YY";
                break;
            case 5: // sicario
                website = "https://www.youtube.com/watch?v=G8tlEcnrGnU";
                break;
                default:
                    website = "https://www.youtube.com";
        }
        return website;
    }


    // matches the position of the ListView click to the IMDb website
    public String getIMDb(int position) {
        String website = "";

        switch (position) {
            case 0:
                website = "https://www.imdb.com/title/tt4154796/";
                break;
            case 1:
                website = "https://www.imdb.com/title/tt6644200/";
                break;
            case 2:
                website = "https://www.imdb.com/title/tt1825683/";
                break;
            case 3:
                website = "https://www.imdb.com/title/tt1431045/";
                break;
            case 4:
                website = "https://www.imdb.com/title/tt5052448/";
            case 5:
                website = "https://www.imdb.com/title/tt3397884/";
                break;
            default:
                website = "https://www.imdb.com";
        }
        return website;
    }


    // matches the position of the ListView click to the movie director's wikipedia page
    public String getWiki(int position) {
        String website = "";

        switch (position) {
            case 0:
                website = "https://en.wikipedia.org/wiki/Russo_brothers";
                break;
            case 1:
                website = "https://en.wikipedia.org/wiki/John_Krasinski";
                break;
            case 2:
                website = "https://en.wikipedia.org/wiki/Ryan_Coogler";
                break;
            case 3:
                website = "https://en.wikipedia.org/wiki/Tim_Miller_(director)";
                break;
            case 4:
                website = "https://en.wikipedia.org/wiki/Jordan_Peele";
            case 5:
                website = "https://en.wikipedia.org/wiki/Denis_Villeneuve";
                break;
            default:
                website = "https://en.wikipedia.org/wiki/Main_Page";
        }
        return website;
    }


    // opens the trailer for the movie when clicked from the floaitng menu
    public void openMenuItem(String website) {
        Intent trailerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(trailerIntent);
    }


    // launches a new activity that sends the title of the clicked movie to display movie information
    public void openInfoActivity(int position) {
        String movieName = "";

        switch (position) {
            case  0:
                movieName = "Avengers";
                break;
            case 1:
                movieName = "A Quiet Place";
                break;
            case 2:
                movieName = "Black Panther";
                break;
            case 3:
                movieName = "Deadpool";
                break;
            case 4:
                movieName = "Get Out";
                break;
            case 5:
                movieName = "Sicario";
                break;
        }

        Intent movieInfoIntent2 = new Intent(MainActivity.this, MovieInfoActivity.class);
        movieInfoIntent2.putExtra("title", movieName);
        startActivity(movieInfoIntent2);
    }

}

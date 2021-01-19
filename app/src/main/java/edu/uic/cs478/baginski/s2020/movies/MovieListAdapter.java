package edu.uic.cs478.baginski.s2020.movies;

import android.widget.BaseAdapter;
import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.ImageView;

/* Creates a customizable adapter that will populate the items of the ListView with an image, title text, and date text */

/* When extending BaseAdapter, must define
    1. getItem()
    2. getItemId()
    3. getCount()
    4. getView()
 */
public class MovieListAdapter extends BaseAdapter {
    private Activity activity;
    private String[] movieNames;
    private String[] releaseDates;
    private int[] imageIDs;

    // constructor will take in all the list display items from the calling activity, as well as the calling activity
    public MovieListAdapter(String[] movieNames, String[] releaseDates, int[] imageIDs, Activity activity) {
        this.movieNames = movieNames;
        this.releaseDates = releaseDates;
        this.imageIDs = imageIDs;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return movieNames.length;
    }

    @Override
    public Object getItem(int position) {
        return movieNames[position];
    }

    @Override
    public long getItemId(int position) {
        return imageIDs[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the views from the calling activity with the item_view.xml layout
        View view = activity.getLayoutInflater().inflate(R.layout.item_view, null);

        // bind variables from the R class
        ImageView poster = (ImageView) view.findViewById(R.id.posters);
        TextView title = (TextView) view.findViewById(R.id.movies);
        TextView date = (TextView) view.findViewById(R.id.releaseDates);

        // recycle views
        if (poster == null) {
            poster = new ImageView(activity);
            poster.setLayoutParams(new RelativeLayout.LayoutParams(40, 120));
            poster.setPadding(10, 10, 10, 10);
            poster.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        // update the view to reflect the movie poster, title, and the release date
        poster.setImageResource(imageIDs[position]);
        title.setText(getItem(position).toString());
        date.setText(releaseDates[position]);

        return view;
    }
}

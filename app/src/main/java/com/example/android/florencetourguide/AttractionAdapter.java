package com.example.android.florencetourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link AttractionAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Attraction} objects.
 */
public class AttractionAdapter extends ArrayAdapter<Attraction> {

    /**
     * Resource ID for the background color for this TAB - category of attractions
     */
    private int mColorResourceId;


    /**
     * Create a new {@link AttractionAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param attractions     is the list of {@link Attraction}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions, int colorResourceId) {
        // Initialize the ArrayAdapter's internal storage for the context
        super(context, 0, attractions);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Attraction} object located at this position in the list
        Attraction attraction = getItem(position);
        // Find the Attraction Name TextView in the list_item.xml layout
        TextView textView = listView.findViewById(R.id.attraction_name);
        // set attraction name on this TextView
        textView.setText(attraction.getName());

        // Find the ImageView in the list_item.xml layout
        ImageView imageView = listView.findViewById(R.id.image);
        // set attraction image on this ImageView
        imageView.setImageResource(attraction.getImageResourceId());
        // Make sure the view is visible
        imageView.setVisibility(View.VISIBLE);


        // Set the theme color for the list item
        View textContainer = listView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        return listView;    // Return the list_item view
    }

}
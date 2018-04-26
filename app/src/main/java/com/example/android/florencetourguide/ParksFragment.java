package com.example.android.florencetourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of parks attractions
 */
public class ParksFragment extends Fragment {

    public ParksFragment() {
        // Required empty public constructor
    }

    /**
     * Override the onCreateView method for this fragment (TAB)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.atractions_list, container, false);
        // Create a list of parks attractions
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(getString(R.string.name_parks_one), getString(R.string.description_parks_one), R.drawable.img_parks_one));
        attractions.add(new Attraction(getString(R.string.name_parks_two), getString(R.string.description_parks_two), R.drawable.img_parks_two));
        attractions.add(new Attraction(getString(R.string.name_parks_three), getString(R.string.description_parks_three), R.drawable.img_parks_three));
        attractions.add(new Attraction(getString(R.string.name_parks_four), getString(R.string.description_parks_four), R.drawable.img_parks_four));
        attractions.add(new Attraction(getString(R.string.name_parks_five), getString(R.string.description_parks_five), R.drawable.img_parks_five));
        attractions.add(new Attraction(getString(R.string.name_parks_six), getString(R.string.description_parks_six), R.drawable.img_parks_six));
        attractions.add(new Attraction(getString(R.string.name_parks_seven), getString(R.string.description_parks_seven), R.drawable.img_parks_seven));
        // Create the AttractionAdapter, whose data source is a list of locations. The adapter knows how to create list items for each item in the list
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.background_parks);
        // Find the ListView object in the attractions_list.xml layout file
        ListView listView = rootView.findViewById(R.id.list);
        // Make the {@link ListView} use the {@link AttractionAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Attraction} in the list.
        listView.setAdapter(adapter);
        // Set a click listener to open the Details Attraction activity when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the attraction name at the given position the user clicked on
                String name = attractions.get(position).getName();
                // Get the attraction description at the given position the user clicked on
                String description = attractions.get(position).getDescription();
                // Get the attraction image resource id at the given position the user clicked on
                int image = attractions.get(position).getImageResourceId();
                //create the Details Attraction Intent and send extra info to Details Attraction Activity
                Intent intent = new Intent(getActivity(), DetailsAttraction.class);
                intent.putExtra("name", name);
                intent.putExtra("description", description);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });
        return rootView;

    }

}

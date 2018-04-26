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
 * {@link Fragment} that displays a list of religious attractions
 */
public class ReligiousFragment extends Fragment {

    public ReligiousFragment() {
        // Required empty public constructor
    }

    /**
     * Override the onCreateView method for this fragment (TAB)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.atractions_list, container, false);
        // Create a list of religious attractions
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(getString(R.string.name_religious_one), getString(R.string.description_religious_one), R.drawable.img_religious_one));
        attractions.add(new Attraction(getString(R.string.name_religious_two), getString(R.string.description_religious_two), R.drawable.img_religious_two));
        attractions.add(new Attraction(getString(R.string.name_religious_three), getString(R.string.description_religious_three), R.drawable.img_religious_three));
        attractions.add(new Attraction(getString(R.string.name_religious_four), getString(R.string.description_religious_four), R.drawable.img_religious_four));
        attractions.add(new Attraction(getString(R.string.name_religious_five), getString(R.string.description_religious_five), R.drawable.img_religious_five));
        attractions.add(new Attraction(getString(R.string.name_religious_six), getString(R.string.description_religious_six), R.drawable.img_religious_six));
        attractions.add(new Attraction(getString(R.string.name_religious_seven), getString(R.string.description_religious_seven), R.drawable.img_religious_seven));
        // Create the AttractionAdapter, whose data source is a list of locations. The adapter knows how to create list items for each item in the list
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.background_religious);
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

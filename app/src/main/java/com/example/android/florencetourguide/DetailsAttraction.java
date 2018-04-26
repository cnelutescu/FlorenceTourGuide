package com.example.android.florencetourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Details Attraction Activity will display the details of the selected attraction
 */
public class DetailsAttraction extends AppCompatActivity {

    /**
     * Override the onCreate method for this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set content view to the attraction_details.xml layout file
        setContentView(R.layout.attraction_details);

        // Get selected attraction name
        String name = getIntent().getStringExtra("name");
        // Find the TextView for the selected attraction name
        TextView nameTextView = findViewById(R.id.detail_name_textview);
        //Set the selected attraction name
        nameTextView.setText(name);

        // Get selected attraction description
        String description = getIntent().getStringExtra("description");
        // Find the TextView for the selected attraction description
        TextView descriptionTextView = findViewById(R.id.detail_description_textview);
        //Set the selected attraction description
        descriptionTextView.setText(description);

        // Get selected attraction image resource id
        int image = getIntent().getIntExtra("image", 0);
        // Find the ImageView for the selected attraction image
        ImageView imageView = findViewById(R.id.detail_image_attraction);
        //Set the selected attraction image
        imageView.setImageResource(image);
    }

}

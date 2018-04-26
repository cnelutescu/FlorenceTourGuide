package com.example.android.florencetourguide;

/**
 * {@link Attraction} represents a attraction that the user wants to see information.
 * It contains a name, a description and an image for that attraction.
 */
public class Attraction {

    private String mName;             // attraction name
    private String mDescription;      // attraction description
    private int mImageResId;          // attraction image resource ID

    /**
     * Create a new Attraction object.
     *
     * @param Name        attraction name
     * @param Description attraction description
     * @param imageResId  drawable resource ID for the image associated with the attraction
     */
    public Attraction(String Name, String Description, int imageResId) {
        mName = Name;
        mDescription = Description;
        mImageResId = imageResId;
    }

    /**
     * Return the name of the attraction
     */
    public String getName() {
        return mName;
    }

    /**
     * Return the description of the attraction
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Return the image resource ID of the attraction
     */
    public int getImageResourceId() {
        return mImageResId;
    }

}


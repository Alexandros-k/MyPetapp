package com.example.alex.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class BrowseActivity extends MenExtender {


    int i;

    public static final String EXTRA_PET_POSITION_IN_LIST = "pet_position_in_list";


    public static Intent getStartIntent(Context context, int petPosInList) {
        Intent intent = new Intent(context, BrowseActivity.class);
        intent.putExtra(EXTRA_PET_POSITION_IN_LIST, petPosInList);

        return intent;
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);

        int petPositionInList = getIntent().getIntExtra(EXTRA_PET_POSITION_IN_LIST, -1);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.placeholder) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            FragmentBrowseActivity firstFragment = FragmentBrowseActivity.newInstance(petPositionInList);

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.placeholder, firstFragment).commit();
        }

    }
}
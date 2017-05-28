package com.example.alex.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class BrowseActivity extends MenExtender {


    int i;

    public static final String EXTRA_PET_POSITION_IN_LIST = "pet_position_in_list";


    public static Intent getStartIntent(Context context, String onPetLocationInList) {
        Intent intent = new Intent(context, BrowseActivity.class);
        intent.putExtra(EXTRA_PET_POSITION_IN_LIST, onPetLocationInList);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_pet_details);

        String onPetLocationInList = getIntent().getStringExtra(EXTRA_PET_POSITION_IN_LIST);

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
            FragmentBrowseActivity firstFragment = FragmentBrowseActivity.newInstance(onPetLocationInList);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();
            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            /*Bundle args = new Bundle();
            args.putString(FragmentBrowseActivity.ARG_PET_POSITION_IN_LIST, onPetLocationInList);
            firstFragment.setArguments(args);*/

            // Add the fragment to the 'fragment_container' FrameLayout
           /* getSupportFragmentManager().beginTransaction()
                    .add(R.id.placeholder, firstFragment).commit();*/


            fragmentTransaction.replace(R.id.placeholder, firstFragment);
            fragmentTransaction.commit();

        }

    }
}
//}
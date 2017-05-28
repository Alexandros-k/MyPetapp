package com.example.alex.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;


public class MainActivity extends MenExtender implements FragmentMainActivity.OnFragmentInteractionListener {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);



    }



    @Override
    public void onPetSelected(String onPetLocationInList ) {
        View fragmentContainer = findViewById(R.id.placeholder);

        /*FragmentBrowseActivity fragment = (FragmentBrowseActivity)
                getSupportFragmentManager().findFragmentById(R.id.fragPetDetailsId);*/


        boolean isDualPane = fragmentContainer != null && fragmentContainer.getVisibility() == View.VISIBLE;

        if (isDualPane) {
          /*  FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.placeholder, FragmentBrowseActivity.newInstance(onPetLocationInList));
            fragmentTransaction.commit();*/

            Fragment newFragment = FragmentBrowseActivity.newInstance(onPetLocationInList);
            FragmentTransaction transaction =
                    getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this
// fragment and add the transaction to the back stack
            transaction.replace(R.id.placeholder, newFragment);
            transaction.addToBackStack(null);

// Commit the transaction
            transaction.commit();


        }else {

            Intent intent = new Intent(this, BrowseActivity.class);
            intent.putExtra(BrowseActivity.EXTRA_PET_POSITION_IN_LIST, onPetLocationInList);

            startActivity(intent);
           // startActivity(BrowseActivity.getStartIntent(this,onPetLocationInList));
        }

    }





}






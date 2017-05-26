package com.example.alex.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;


public class MainActivity extends MenExtender implements FragmentMainActivity.OnFragmentInteractionListener {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);


     /*   FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.placeholder);
        if (fragment == null) {
            fragment = new FragmentMainActivity();
            fm.beginTransaction()
                    .add(R.id.placeholder, fragment)
                    .commit();
        }*/

    }



    @Override
    public void onPetSelected(String petIntent) {
        View fragmentContainer = findViewById(R.id.placeholder);
        boolean isDualPane = fragmentContainer != null && fragmentContainer.getVisibility() == View.VISIBLE;

        if (isDualPane) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            FragmentBrowseActivity fragment = new FragmentBrowseActivity();
            Bundle args = new Bundle();
            args.putString(FragmentBrowseActivity.EXTRA_NEW_PET_INTENT, petIntent);

            fragment.setArguments(args);
            fragmentTransaction.replace(R.id.placeholder, fragment);
            fragmentTransaction.commit();
        }else {
            Intent intent = new Intent(this, BrowseActivity.class);
            intent.putExtra(BrowseActivity.EXTRA_PET_INTENT, petIntent);

            startActivity(intent);
        }

    }





}






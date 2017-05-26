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
    public void onPetSelected(int petLocInList) {
        View fragmentContainer = findViewById(R.id.placeholder);



        boolean isDualPane = fragmentContainer != null && fragmentContainer.getVisibility() == View.VISIBLE;

        if (isDualPane) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.placeholder, FragmentBrowseActivity.newInstance(petLocInList));
            fragmentTransaction.commit();
        }else {


            startActivity(BrowseActivity.getStartIntent(this,petLocInList));
        }

    }





}






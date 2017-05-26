package com.example.alex.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

public class BrowseActivity extends MenExtender {


    int i;

    public static final String EXTRA_PET_INTENT = "extra_pet_intent";

/*
    public static Intent getStartIntent(Context context, int petPositionInList) {
        Intent intent = new Intent(context, BrowseActivity.class);
        intent.putExtra(EXTRA_PET_INTENT, petPositionInList);

        return intent;
    }
*/
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);

        String newPetIntent = getIntent().getStringExtra(EXTRA_PET_INTENT);


        FragmentBrowseActivity frag = new FragmentBrowseActivity();
        FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
        Bundle args = new Bundle();
        args.putString(FragmentBrowseActivity.EXTRA_NEW_PET_INTENT, newPetIntent);

        frag.setArguments(args);
        tr.replace(R.id.fragment_container, frag);
        tr.commit();


       /* FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.placeholder);
        if (fragment == null) {
            fragment = new FragmentBrowseActivity();
            fm.beginTransaction()
                    .add(R.id.placeholder, fragment)
                    .commit();
        }*/


    }


}
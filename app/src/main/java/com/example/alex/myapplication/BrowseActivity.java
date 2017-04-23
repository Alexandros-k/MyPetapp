package com.example.alex.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BrowseActivity extends AppCompatActivity {

    int count;
    Button button;
    Button button2;
    TextView h1;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browseactivity);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("bla", count);
        }

        PetDbHelper myDb = new PetDbHelper(this);

        final List<Pet> pet = myDb.getPets();


        final String petIntent1 = getIntent().getExtras().getString("Id");

        for (int i = 0; i < pet.size(); i++) {

            if (pet.get(i).getName().equals(petIntent1)) {

                final TextView t4 = (TextView) findViewById(R.id.idspecies);
                t4.setText(pet.get(i).getSpecies());
                final TextView t1 = (TextView) findViewById(R.id.IdName);
                t1.setText(pet.get(i).getSpecies() + "'name :" + pet.get(i).getName());
                final TextView t2 = (TextView) findViewById(R.id.idspecies);
                t2.setText(pet.get(i).getSpecies() + "'race :" + pet.get(i).getBreed());
                final ImageView i1 = (ImageView) findViewById(R.id.Pic);
                i1.setImageResource(pet.get(i).getImageUri());
                final TextView t3 = (TextView) findViewById(R.id.idComments);
                t3.setText(pet.get(i).getSpecies() + "'info :" + pet.get(i).getComments());
            }

        }


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("bla", count);
    }


}


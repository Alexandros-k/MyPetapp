package com.example.alex.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PetDetailsActivity extends AppCompatActivity {

    int count;
    Button button;
    Button button2;

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
    TextView t8;
    TextView t9;
    TextView t10;
    TextView t11;
    TextView t12;
    TextView t13;
    TextView t14;
    TextView t15;
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

                final TextView t1 = (TextView) findViewById(R.id.IdName);
                t1.setText( " name :" + pet.get(i).getName());
                final TextView t2 = (TextView) findViewById(R.id.IdDateOfBirth);
                t2.setText(" Date Of Birth :" + pet.get(i).getDateOfBirth());
                final TextView t3 = (TextView) findViewById(R.id.idGender);
                t3.setText(" Gender :" + pet.get(i).getGender());
                final TextView t4 = (TextView) findViewById(R.id.IdBreed);
                t4.setText(" Breed :" + pet.get(i).getBreed());
                final TextView t5 = (TextView) findViewById(R.id.idColour);
                t5.setText( " Colour :" + pet.get(i).getColour());
                final TextView t6 = (TextView) findViewById(R.id.idDistinguishingMarks);
                t6.setText(" Distinguishing Marks :" + pet.get(i).getDistinguishingMarks());
                final TextView t7 = (TextView) findViewById(R.id.idChipId);
                t7.setText(" ChipID :" + pet.get(i).getChipID());
                final TextView t8 = (TextView) findViewById(R.id.idOwnerName);
                t8.setText(" Owner's Name :" + pet.get(i).getOwnerName());
                final TextView t9 = (TextView) findViewById(R.id.idOwnerAddress);
                t9.setText(" Owner's Address :" + pet.get(i).getOwnerAddress());
                final TextView t10 = (TextView) findViewById(R.id.idOwnerPhone);
                t10.setText( " Owner's Phone :" + pet.get(i).getOwnerPhone());
                final TextView t11 = (TextView) findViewById(R.id.idVetName);
                t11.setText(" Vet's Name :"  + pet.get(i).getVetName());
                final TextView t12 = (TextView) findViewById(R.id.idVetAddress);
                t12.setText(" Vet's Address :" + pet.get(i).getVetAddress());
                final TextView t13 = (TextView) findViewById(R.id.idVetPhone);
                t13.setText(" Vet's Phone :" + pet.get(i).getVetPhone());
                final TextView t14 = (TextView) findViewById(R.id.idComments);
                t14.setText(" Comments :" + pet.get(i).getComments());
                final TextView t15 = (TextView) findViewById(R.id.idspecies);
                t15.setText(" Species :" + pet.get(i).getSpecies());
                final ImageView i1 = (ImageView) findViewById(R.id.Pic);
                i1.setImageResource(pet.get(i).getImageUri());
            }

        }


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("bla", count);
    }


}


package com.example.alex.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {

    int count ;
    Button button;
    Button button2;
    TextView h1;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    ImageView i1;

    ArrayList<Pet> pet = new ArrayList<>();

    Pet p1 =new Pet("Dog","Jack", "canis", R.drawable.canis, "dasd","jc");
    Pet p2 =new Pet("Cat","liono", "British_short_hair", R.drawable.british_short_hair, "dasd","lb");
    Pet p3 =new Pet("Other","Sala", "snake", R.drawable.canis, "dasd","jco");
    Pet p4 =new Pet("Dog","Nick", "colley", R.drawable.colley, "dasd","nc");
    Pet p5 =new Pet("Cat","chitara", "Maine_coon", R.drawable.maine_coon, "dasd","cm");
    Pet p6 =new Pet("Other","Spidy", "Spider", R.drawable.canis, "dasd","jco1");
    Pet p7 =new Pet("Dog","Rex", "labrador", R.drawable.lab, "dasd","rl");
    Pet p8 =new Pet("Cat","tigra", "Ragdoll", R.drawable.ragdoll, "dasd","tr");
    Pet p9 =new Pet("Other","Venom", "symbiot", R.drawable.canis, "dasd","jc");
    Pet p10 =new Pet("Dog","Azor", "husky", R.drawable.husky, "dasd","ah");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browseactivity);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("bla", count);
        }


        pet.add(p1);
        pet.add(p2);
        pet.add(p3);
        pet.add(p4);
        pet.add(p5);
        pet.add(p6);
        pet.add(p7);
        pet.add(p8);
        pet.add(p9);
        pet.add(p10);


        final String petIntent1= getIntent().getExtras().getString("Id");

        for (int i = 0; i <pet.size() ; i++) {

            if(pet.get(i).getName().equals(petIntent1)) {

                final TextView t4 = (TextView) findViewById(R.id.idspecies);
                t4.setText(pet.get(i).getSpecies());
                final TextView t1 = (TextView) findViewById(R.id.Name);
                t1.setText(pet.get(i).getSpecies() + "'name :" + pet.get(i).getName());
                final TextView t2 = (TextView) findViewById(R.id.Race);
                t2.setText(pet.get(i).getSpecies() + "'race :" + pet.get(i).race);
                final ImageView i1 = (ImageView) findViewById(R.id.Pic);
                i1.setImageResource(pet.get(i).image);
                final TextView t3 = (TextView) findViewById(R.id.Info);
                t3.setText(pet.get(i).getSpecies() + "'info :" + pet.get(i).text);
            }

        }





    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("bla", count);
    }


}


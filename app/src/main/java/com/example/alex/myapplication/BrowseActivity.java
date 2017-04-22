package com.example.alex.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {




    Pet p1 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.canis);
    Pet p2 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.british_short_hair);
    Pet p3 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.canis);
    Pet p4 =new Pet("jack","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.colley);
    Pet p5 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.maine_coon);
    Pet p6 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.canis);
    Pet p7 =new Pet("nick","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.lab);
    Pet p8 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.ragdoll);
    Pet p9 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.canis);
    Pet p10 =new Pet("rain","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.husky);

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







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browseactivity);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("bla", count);
        }

        final  ArrayList<Pet> pet = new ArrayList<>();
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


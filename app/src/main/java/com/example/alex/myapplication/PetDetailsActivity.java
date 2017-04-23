package com.example.alex.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import static com.example.alex.myapplication.R.id.PetDetailsId;

public class PetDetailsActivity extends AppCompatActivity {

    PetDbHelper myDb;
    /*
        Pet p1 = new Pet("kiko", "1984", "male", "pitbul", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Dog", R.drawable.canis);
        Pet p2 = new Pet("kiko", "1984", "male", "pitbul", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "dog", R.drawable.british_short_hair);
        Pet p3 = new Pet("kiko", "1984", "male", "pitbul", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Other", R.drawable.canis);
        Pet p4 = new Pet("jack", "1984", "male", "pitbul", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Dog", R.drawable.colley);
        Pet p5 = new Pet("kiko", "1984", "male", "pitbul", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Cat", R.drawable.maine_coon);
        Pet p6 = new Pet("kiko", "1984", "male", "pitbul", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Other", R.drawable.canis);
        Pet p7 = new Pet("nick", "1984", "male", "pitbul", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Dog", R.drawable.lab);
        Pet p8 = new Pet("kiko", "1984", "male", "pitbul", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Cat", R.drawable.ragdoll);
        Pet p9 = new Pet("kiko", "1984", "male", "pitbul", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Other", R.drawable.canis);
        Pet p10 = new Pet("rain", "1984", "male", "pitbul", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Dog", R.drawable.husky);
       */
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);

        myDb = new PetDbHelper(this);


        final String petIntent = getIntent().getExtras().getString("Species");

        final List<Pet> pet = myDb.getPets();


        ListView listview = (ListView) findViewById(PetDetailsId);
        PetAdaptrer petAdaptrer = new PetAdaptrer(getApplicationContext(), R.layout.activity_pet_details);
        listview.setAdapter(petAdaptrer);

        for (i = 0; i < pet.size(); i++)

        {

            System.out.println(pet.get(i).getSpecies()+"   "+petIntent);
            if (pet.get(i).getSpecies().equals(petIntent)) {

                PetDataProvider petDataProvider = new PetDataProvider(
                        pet.get(i).getImageUri(), pet.get(i).getName(), pet.get(i).getBreed());
                petAdaptrer.add(petDataProvider);

            }
        }


        final ListView listView = (ListView) findViewById(PetDetailsId);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PetDetailsActivity.this, BrowseActivity.class);


                String result = (String) listView.getItemAtPosition(position).toString();
                intent.putExtra("Id", result);

                startActivity(intent);
            }
        });


    }

}

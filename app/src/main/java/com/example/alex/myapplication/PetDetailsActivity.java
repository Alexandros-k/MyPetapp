package com.example.alex.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.alex.myapplication.R.id.PetDetailsId;

public class PetDetailsActivity extends AppCompatActivity {


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
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);




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


        final String petIntent = getIntent().getExtras().getString("Species");

            ListView listview = (ListView) findViewById(PetDetailsId);
            PetAdaptrer petAdaptrer = new PetAdaptrer(getApplicationContext(), R.layout.activity_pet_details);
            listview.setAdapter(petAdaptrer);

        for ( i = 0; i < pet.size(); i++) {
            if (pet.get(i).getSpecies().equals(petIntent)) {

                PetDataProvider petDataProvider = new PetDataProvider(
                        pet.get(i).image, pet.get(i).getName(), pet.get(i).getRace());
                petAdaptrer.add(petDataProvider);

            }
        }


          final   ListView listView = (ListView) findViewById(PetDetailsId);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(PetDetailsActivity.this, BrowseActivity.class);


                    String result = (String) listView.getItemAtPosition(position).toString();
                    intent.putExtra("Id",result);

                    startActivity(intent);
                }
            });




    }

}

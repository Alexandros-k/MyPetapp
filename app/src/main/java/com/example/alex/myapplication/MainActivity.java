package com.example.alex.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.alex.myapplication.R.id.SpeciesView;


public class MainActivity extends AppCompatActivity {
    PetDbHelper mPetDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        mPetDbHelper = new PetDbHelper(this);
        String[] species = {"Dogs", "Cats", "Other"};

        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this, R.layout.speciesview, species);

        ListView list=(ListView) findViewById(SpeciesView);
        list.setAdapter(adapter);

        ListView listView = (ListView) findViewById(SpeciesView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch(position) {
                    case 0:
                        intent = new Intent(MainActivity.this, PetDetailsActivity.class);
                        intent.putExtra("Species", "Dog");
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, PetDetailsActivity.class);
                        intent.putExtra("Species", "Cat");
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, PetDetailsActivity.class);
                        intent.putExtra("Species", "Other");
                        break;
                }


                startActivity(intent);
            }
        });






    }


}
















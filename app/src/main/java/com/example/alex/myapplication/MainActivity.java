package com.example.alex.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static com.example.alex.myapplication.R.id.SpeciesView;


public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

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
/**
     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, PetDetailsActivity.class);
                intent.putExtra("Species", "Cat");

                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, PetDetailsActivity.class);
                intent.putExtra("Species", "Other");

                startActivity(intent);
            }
        });



**/





    }
}









/**button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {


        Intent intent = new Intent(MainActivity.this, BrowseActivity.class);
        intent.putExtra("Species", "Dog");

        startActivity(intent);

        }
        }
        );
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, BrowseActivity.class);
        intent.putExtra("Species", "Cat");


        startActivity(intent);

        }
        }
        );
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, BrowseActivity.class);
        intent.putExtra("Species", "Other");
        startActivity(intent);

        }
        }

        );
 Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
 setSupportActionBar(toolbar);

 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
 MenuInflater inflater = getMenuInflater();
 inflater.inflate(R.menu.menu, menu);
 return true;
 }

 private void registerClickCallBack() {
 ListView listView = (ListView) findViewById(SpeciesView);
 listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
 @Override
 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
 Intent intent = new Intent(MainActivity.this, BrowseActivity.class);
 intent.putExtra("Species", "Dog");

 startActivity(intent);
 }
 });
 }
 private void speciesCreate(){


 String[] species = {"Dogs", "Cats", "Other"};

 ArrayAdapter<String> adapter = new
 ArrayAdapter<String>(this, R.layout.speciesview, species);

 ListView list=(ListView) findViewById(SpeciesView);
 list.setAdapter(adapter);

 }
 }
 **/







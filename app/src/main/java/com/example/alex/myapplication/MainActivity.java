package com.example.alex.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        mPetDbHelper.initDb();
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
                        intent = new Intent(MainActivity.this, BrowseActivity.class);
                        intent.putExtra("Species", "Dog");
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, BrowseActivity.class);
                        intent.putExtra("Species", "Cat");
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, BrowseActivity.class);
                        intent.putExtra("Species", "Other");
                        break;
                }
                startActivity(intent);



            }
        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
        MenuItem logout = menu.findItem(R.id.idLogout);
        MenuItem login = menu.findItem(R.id.idLogin);
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String userDetailsName = preferences.getString("newUsername", "");
        System.out.println("auto einai"+ userDetailsName);


        if(userDetailsName.isEmpty()) {
            login.setVisible(true);
            logout.setVisible(false);

        }else{
            login.setVisible(false);
            logout.setVisible(true);

        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.idLogin:
                Intent LoginScreen = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(LoginScreen);


                return true;

            case R.id.idLogout:
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                Intent LognScreen = new Intent(MainActivity.this,MainActivity.class);
                startActivity(LognScreen);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
















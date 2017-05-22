package com.example.alex.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import static com.example.alex.myapplication.R.id.PetDetailsId;

public class BrowseActivity extends FragmentActivity {

    PetDbHelper myDb;

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String userDetailsName = preferences.getString("newUsername", "");
                System.out.println("auto einai2"+" "+ userDetailsName);
                if(!userDetailsName.isEmpty()) {


                         Intent intent = new Intent(BrowseActivity.this, PetDetailsActivity.class);


                         String result = (String) listView.getItemAtPosition(position).toString();
                         intent.putExtra("Id", result);

                         startActivity(intent);
                  }else{

                Toast toast = Toast.makeText(BrowseActivity.this, "please register first", Toast.LENGTH_SHORT);
                toast.show();

            }

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
        System.out.println(userDetailsName);
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
                Intent LoginScreen = new Intent(BrowseActivity.this,LoginActivity.class);
                startActivity(LoginScreen);


                return true;

            case R.id.idLogout:
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                Intent LognScreen = new Intent(BrowseActivity.this,MainActivity.class);
                startActivity(LognScreen);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
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
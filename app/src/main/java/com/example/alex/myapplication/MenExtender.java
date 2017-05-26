package com.example.alex.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by Alex on 5/26/2017.
 */

public class MenExtender extends AppCompatActivity {



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
            login.setVisible(true);
            logout.setVisible(true);

        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.idLogin:
                Intent LoginScreen = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(LoginScreen);


                return true;

            case R.id.idLogout:
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                Intent LognScreen = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(LognScreen);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }




}

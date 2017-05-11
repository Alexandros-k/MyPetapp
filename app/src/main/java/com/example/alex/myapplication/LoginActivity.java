package com.example.alex.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText loginUsername = (EditText) findViewById(R.id.idNewName);
        final EditText loginPassword = (EditText) findViewById(R.id.idPassword);

        Button btnLogin = (Button) findViewById(R.id.idLoginButton);
        Button btnRegister = (Button) findViewById(R.id.idButtonRegister);


        btnLogin.setOnClickListener(new View.OnClickListener() {


                                        @Override
                                        public void onClick(View v) {

                                            String user = loginUsername.getText().toString();
                                            String password = loginPassword.getText().toString();

                                            SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                                            String userDetailsName = preferences.getString("newUsername", "not exist");


                                            if (user.equals(userDetailsName)) {


                                                Intent displayScreen = new Intent(LoginActivity.this, MainActivity.class);
                                                startActivity(displayScreen);
                                            } else {
                                                Context context = getApplicationContext();
                                                CharSequence text = "Please Register First";
                                                int duration = Toast.LENGTH_SHORT;

                                                Toast toast = Toast.makeText(context, text, duration);
                                                toast.show();


                                            }


                                        }
                                    }


        );


        btnRegister.setOnClickListener(new View.OnClickListener() {


                                           @Override
                                           public void onClick(View v) {
                                               Intent RegisterScreen = new Intent(LoginActivity.this, RegisterActivity.class);
                                               startActivity(RegisterScreen);
                                           }
                                       }


        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
        MenuItem logout = menu.findItem(R.id.idLogout);
        logout.setVisible(true);
        return true;


    }
}
package com.example.alex.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText loginUsername = (EditText) findViewById(R.id.idNewUsername);
        final EditText loginPassword = (EditText) findViewById(R.id.idPassword);

        Button btnLogin = (Button) findViewById(R.id.idLoginButton1);
        Button btnRegister = (Button) findViewById(R.id.idRegisterButton);


        btnLogin.setOnClickListener(new View.OnClickListener() {


                                        @Override
                                        public void onClick(View v) {

                                            String username = loginUsername.getText().toString();
                                            String password = loginPassword.getText().toString();

                                          SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                                            String userDetailsName = preferences.getString("newUsername", "not exist");


                                            if (username.equals(userDetailsName)) {


                                                Intent displayScreen = new Intent(LoginActivity.this, MainActivity.class);
                                                startActivity(displayScreen);
                                            } else {

                                                Toast toast = Toast.makeText(LoginActivity.this, "Please Register First", Toast.LENGTH_SHORT);
                                                toast.show();
                                            }


                                                Intent intent = new Intent(LoginActivity.this, UserService.class);
                                                intent.setAction(UserService.ACTION_GET_USERS);

                                                intent.putExtra(UserService.URL_USERNAME, username);
                                                intent.putExtra(UserService.URL_PASSWORD, password);

                                                startService(intent);

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


}

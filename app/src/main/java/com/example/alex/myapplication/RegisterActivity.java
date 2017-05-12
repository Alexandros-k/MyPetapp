package com.example.alex.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class RegisterActivity extends AppCompatActivity {


    private BroadcastReceiver getAllStudentsResultBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String studentResults = intent.getStringExtra(UserService.EXTRA_USERS_RESULT);

            User[] users = new Gson().fromJson(studentResults, User[].class);

            String result = "";

            for (int i = 0; i < users.length; i++) {
                User user = users[i];
                result += user.getFirstName() + "\t" + user.getLastName() + "\t"  + "\n";
            }


        }
    };

    private BroadcastReceiver createStudentResultBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String resultMsg = intent.getStringExtra(UserService.EXTRA_CREATE_USER_RESULT);

            Toast.makeText(RegisterActivity.this, resultMsg, Toast.LENGTH_SHORT).show();
        }
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText registerUsername = (EditText) findViewById(R.id.idRegUsername);
        final EditText registerPassword = (EditText) findViewById(R.id.idRegPassword);
        final EditText confirmPassWord = (EditText) findViewById(R.id.idRegConfirmPassword);
        final EditText Name = (EditText) findViewById(R.id.idName);
        final EditText surname = (EditText) findViewById(R.id.idSurname);



        Button btnRegister = (Button)findViewById(R.id.idRegisterButton);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                     // stelnei name -last name ston server
                findViewById(R.id.idRegisterButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String username =registerUsername.getText().toString();
                        String password =registerPassword.getText().toString();
                        String firstName = Name.getText().toString();
                        String lastName =surname.getText().toString();
                        insertStudent(firstName,lastName,username,password);
                    }
                });








                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser =registerUsername.getText().toString();
                String newPassword =registerPassword.getText().toString();
                String confirmaPassw =confirmPassWord.getText().toString();
                String newName =Name.getText().toString();
                String newSurname =surname.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
               if(newPassword.equals(confirmaPassw) && newPassword.length()>=6 && confirmaPassw.length()>=6 &&
                        newUser !=null && newName != null && newSurname !=null ) {
                    editor.putString("newUsername", newUser);
                    editor.apply();

                    Intent loginScreen = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(loginScreen);
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "FILL ALL FIELDS";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);

        IntentFilter getStudentsResultIntentFilter = new IntentFilter(UserService.ACTION_GET_USERS_RESULT);
        broadcastManager.registerReceiver(getAllStudentsResultBroadcastReceiver, getStudentsResultIntentFilter);

        IntentFilter createStudentResultIntentFilter = new IntentFilter(UserService.ACTION_CREATE_USER_RESULT);
        broadcastManager.registerReceiver(createStudentResultBroadcastReceiver, createStudentResultIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);

        broadcastManager.unregisterReceiver(getAllStudentsResultBroadcastReceiver);
        broadcastManager.unregisterReceiver(createStudentResultBroadcastReceiver);
    }
    private void insertStudent(String firstName, String lastName, String username, String password) {
        Intent intent = new Intent(this, UserService.class);
        intent.setAction(UserService.ACTION_CREATE_USER);

        intent.putExtra(UserService.EXTRA_FIRST_NAME, firstName);
        intent.putExtra(UserService.EXTRA_LAST_NAME, lastName);
        intent.putExtra(UserService.EXTRA_USERNAME, username);
        intent.putExtra(UserService.EXTRA_PASSWORD, password);

        startService(intent);
    }

    private void getAllStudents() {
        Intent intent = new Intent(this, UserService.class);
        intent.setAction(UserService.ACTION_GET_USERS);

        startService(intent);
    }



}

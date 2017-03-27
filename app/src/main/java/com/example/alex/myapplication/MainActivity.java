package com.example.alex.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

         button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

                                           //Intent i1= new Intent(MainActivity.this,BrowseActivity.class);

                                              // Intent intent = new Intent("com.example.alex.myapplication.BrowseActivity");
                                           Intent intent = new Intent(MainActivity.this,BrowseActivity.class);
                                                intent.putExtra("Species","dog");

                                               startActivity(intent);

                                       }
                                   }
        );
         button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(MainActivity.this,BrowseActivity.class);
                                          intent.putExtra("Species","cat");

                                              //ntent intent = new Intent("com.example.alex.myapplication.BrowseActivity");
                                              startActivity(intent);

                                      }
                                  }
        );
         button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                          public void onClick(View v) {
                                          Intent intent = new Intent(MainActivity.this,BrowseActivity.class);
                                          intent.putExtra("Species","others");
                                          startActivity(intent);
                                             // TextView t1 = (TextView) findViewById(R.id.textView1);
                                             // t1.setVisibility(View.VISIBLE);
                                             // button1.setVisibility(View.INVISIBLE);
                                             // button2.setVisibility(View.INVISIBLE);
                                             // button3.setVisibility(View.INVISIBLE);
                                          }
                                      }

        );

    }

}








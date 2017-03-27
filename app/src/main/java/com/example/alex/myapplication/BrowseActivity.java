package com.example.alex.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browseactivity);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("bla", count);
        }

        final ArrayList<Dog> dog = new ArrayList<>();
        Dog d1 = new Dog("Jack", "canis", R.drawable.canis, "dasd");
        Dog d2 = new Dog("Nick", "colley", R.drawable.colley, "dasd");
        Dog d3 = new Dog("Rex", "labrador", R.drawable.lab, "dasd");

        dog.add(d1);
        dog.add(d2);
        dog.add(d3);
        final TextView t1 = (TextView) findViewById(R.id.Name);
        t1.setText(dog.get(count).name);
        final TextView t2 = (TextView) findViewById(R.id.Race);

        t2.setText(dog.get(count).race);
        final ImageView i1 = (ImageView) findViewById(R.id.Pic);
        i1.setImageResource(dog.get(count).image);
        final TextView t3 = (TextView) findViewById(R.id.Info);
        t3.setText(dog.get(count).text);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          count++;
                                          if (count > 2) {
                                              count = 0;
                                          }
                                          final TextView t1 = (TextView) findViewById(R.id.Name);
                                          t1.setText(dog.get(count).name);
                                          final TextView t2 = (TextView) findViewById(R.id.Race);

                                          t2.setText(dog.get(count).race);
                                          final ImageView i1 = (ImageView) findViewById(R.id.Pic);
                                          i1.setImageResource(dog.get(count).image);
                                          final TextView t3 = (TextView) findViewById(R.id.Info);
                                          t3.setText(dog.get(count).text);



                                      }



                                  }
        );

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count--;
                if (count < 0) {
                    count = 2;
                }
                final TextView t1 = (TextView) findViewById(R.id.Name);
                t1.setText(dog.get(count).name);
                final TextView t2 = (TextView) findViewById(R.id.Race);

                t2.setText(dog.get(count).race);
                final ImageView i1 = (ImageView) findViewById(R.id.Pic);
                i1.setImageResource(dog.get(count).image);
                final TextView t3 = (TextView) findViewById(R.id.Info);
                t3.setText(dog.get(count).text);


            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("bla", count);
    }
}




package com.example.alex.myapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {

    int count = 0;
    Button button;
    Button button2;
    TextView h1;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    ImageView i1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browseactivity);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("bla", count);
        }

        final ArrayList<Other> other = new ArrayList<>();

        final ArrayList<Cat> cat = new ArrayList<>();
        Cat c1 = new Cat("liono", "Lion");
        Cat c2 = new Cat("chitara", "Chitah");
        Cat c3 = new Cat("tigra", "tiger");
        cat.add(c1);
        cat.add(c2);
        cat.add(c3);



        final ArrayList<Dog> dog = new ArrayList<>();
        Dog d1 = new Dog("Jack", "canis", R.drawable.canis, "dasd");
        Dog d2 = new Dog("Nick", "colley", R.drawable.colley, "dasd");
        Dog d3 = new Dog("Rex", "labrador", R.drawable.lab, "dasd");

        dog.add(d1);
        dog.add(d2);
        dog.add(d3);
        if(getIntent().getExtras().getString("Species").equals("dog")) {
            final TextView t1 = (TextView) findViewById(R.id.Name);
            t1.setText(dog.get(count).name);
            final TextView t2 = (TextView) findViewById(R.id.Race);
            t2.setText(dog.get(count).race);
            final ImageView i1 = (ImageView) findViewById(R.id.Pic);
            i1.setImageResource(dog.get(count).image);
            final TextView t3 = (TextView) findViewById(R.id.Info);
            t3.setText(dog.get(count).text);
        }else if(getIntent().getExtras().getString("Species").equals("cat")){
            final TextView t1 = (TextView) findViewById(R.id.Name);
            t1.setText(cat.get(count).name);
            final TextView t2 = (TextView) findViewById(R.id.Race);
            t2.setText(cat.get(count).race);
             i1 = (ImageView) findViewById(R.id.Pic);
            i1.setVisibility(View.INVISIBLE);
            final TextView t3 = (TextView) findViewById(R.id.Info);
            t3.setVisibility(View.INVISIBLE);

        }else if(getIntent().getExtras().getString("Species").equals("others")){
             h1 = (TextView) findViewById(R.id.hidden);
            h1.setVisibility(View.VISIBLE);
            final TextView t1 = (TextView) findViewById(R.id.Name);
            t1.setVisibility(View.INVISIBLE);
            final TextView t2 = (TextView) findViewById(R.id.Race);
          t2.setVisibility(View.INVISIBLE);
            final TextView t3 = (TextView) findViewById(R.id.Info);
            t3.setVisibility(View.INVISIBLE);

            i1 = (ImageView) findViewById(R.id.Pic);
           i1.setVisibility(View.INVISIBLE);
            final TextView t4 = (TextView) findViewById(R.id.textView4);
            t4.setVisibility(View.INVISIBLE);
            final TextView t5 = (TextView) findViewById(R.id.textView5);
            t5.setVisibility(View.INVISIBLE);
            final TextView t6 = (TextView) findViewById(R.id.textView3);
            t6.setVisibility(View.INVISIBLE);
        }

         button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          count++;
                                          if (count > 2) {
                                              count = 0;
                                          }
                                          if(getIntent().getExtras().getString("Species").equals("dog")) {
                                              final TextView t1 = (TextView) findViewById(R.id.Name);
                                              t1.setText(dog.get(count).name);
                                              final TextView t2 = (TextView) findViewById(R.id.Race);

                                              t2.setText(dog.get(count).race);
                                              final ImageView i1 = (ImageView) findViewById(R.id.Pic);
                                              i1.setImageResource(dog.get(count).image);
                                              final TextView t3 = (TextView) findViewById(R.id.Info);
                                              t3.setText(dog.get(count).text);
                                          }else if(getIntent().getExtras().getString("Species").equals("cat")) {
                                              final TextView t1 = (TextView) findViewById(R.id.Name);
                                              t1.setText(cat.get(count).name);
                                              final TextView t2 = (TextView) findViewById(R.id.Race);
                                              t2.setText(cat.get(count).race);
                                          }



                                      }



                                  }
        );

         button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count--;
                if (count < 0) {
                    count = 2;
                }
                if(getIntent().getExtras().getString("Species").equals("dog")) {
                    final TextView t1 = (TextView) findViewById(R.id.Name);
                    t1.setText(dog.get(count).name);
                    final TextView t2 = (TextView) findViewById(R.id.Race);

                    t2.setText(dog.get(count).race);
                    final ImageView i1 = (ImageView) findViewById(R.id.Pic);
                    i1.setImageResource(dog.get(count).image);
                    final TextView t3 = (TextView) findViewById(R.id.Info);
                    t3.setText(dog.get(count).text);
                }else if(getIntent().getExtras().getString("Species").equals("cat")) {
                    final TextView t1 = (TextView) findViewById(R.id.Name);
                    t1.setText(cat.get(count).name);
                    final TextView t2 = (TextView) findViewById(R.id.Race);
                    t2.setText(cat.get(count).race);
                }


            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("bla", count);
    }
    public static Intent makeIntent(Context context,Dog dog){
        Intent intent =new Intent(context,BrowseActivity.class);
        intent.putExtra("com.example.alex.myapplication.BrowseActivity- name",dog.getName());
        return intent;
    }

}




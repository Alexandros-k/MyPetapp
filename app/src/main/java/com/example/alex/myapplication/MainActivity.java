package com.example.alex.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         class Dog {

             private String name;
            String race;

            private Dog(String name, String race){
                this.name=name;
                this.race=race;


            }


        }

        final ArrayList<Dog> dog= new ArrayList<>();

         Dog d1 = new Dog("Rex","kanis");
         Dog d2= new Dog("Jack","Lambrador");
        Dog d3 = new Dog("Nick","kolley");

        dog.add(d1);
        dog.add(d2);
        dog.add(d3);


        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                if(count>2 ){count=0;}
                    TextView t1 = (TextView) findViewById(R.id.Name);
                    t1.setText(dog.get(count).name);
                    TextView t2 = (TextView) findViewById(R.id.Race);
                    t2.setText(dog.get(count).race);
                }
                //mou bgazei thema kai den deixnei to object stin thesi 0
                // pws to kanw na ksekinaei kai na deixnei ena object hardcoded i me kodika ?

        });

        Button button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count--;
                if(count<0 ){count=2;}
                        TextView t1 = (TextView) findViewById(R.id.Name);
                        t1.setText(dog.get(count ).name);
                        TextView t2 = (TextView) findViewById(R.id.Race);
                        t2.setText(dog.get(count).race);


            }
        });

    }
}








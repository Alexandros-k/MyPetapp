package com.example.alex.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.alex.myapplication.R.id.PetDetailsId;

public class PetDetailsActivity extends AppCompatActivity {

    PetDbHelper myDb;

    Pet p1 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","Dog","3", R.drawable.canis);
    Pet p2 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.british_short_hair);
    Pet p3 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","Other","3", R.drawable.canis);
    Pet p4 =new Pet("jack","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","Dog","3", R.drawable.colley);
    Pet p5 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","Cat","3", R.drawable.maine_coon);
    Pet p6 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","Other","3", R.drawable.canis);
    Pet p7 =new Pet("nick","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","Dog","3", R.drawable.lab);
    Pet p8 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","Cat","3", R.drawable.ragdoll);
    Pet p9 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","Other","3", R.drawable.canis);
    Pet p10 =new Pet("rain","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","Dog","3", R.drawable.husky);
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);

myDb=new PetDbHelper(this);


           final  ArrayList<Pet> pet = new ArrayList<>();
            pet.add(p1);
            pet.add(p2);
            pet.add(p3);
            pet.add(p4);
            pet.add(p5);
            pet.add(p6);
            pet.add(p7);
            pet.add(p8);
            pet.add(p9);
            pet.add(p10);
                                                    
Cursor res =myDb.getAllData();
        if(res.getCount() ==0){
            //show message
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("ID :"+ res.getString(0)+"\n");
            buffer.append("name :"+ res.getString(1)+"\n");
            buffer.append("date_of_birth :"+ res.getString(2)+"\n");
            buffer.append("gender :"+ res.getString(3)+"\n");
            buffer.append("breed :"+ res.getString(4)+"\n");
            buffer.append("colour :"+ res.getString(5)+"\n");
            buffer.append("distinguishing_marks :"+ res.getString(6)+"\n");
            buffer.append("chip_id :"+ res.getString(7)+"\n");
            buffer.append("owner_name :"+ res.getString(8)+"\n");
            buffer.append("owner_address :"+ res.getString(9)+"\n");
            buffer.append("owner_phone :"+ res.getString(10)+"\n");
            buffer.append("vet_name :"+ res.getString(11)+"\n");
            buffer.append("vet_address :"+ res.getString(12)+"\n");
            buffer.append("vet_phone :"+ res.getString(13)+"\n");
            buffer.append("comments :"+ res.getString(14)+"\n");
            buffer.append("species :"+ res.getString(15)+"\n");
            buffer.append("name_id :"+ res.getString(16)+"\n");
            buffer.append("image_uri :"+ res.getString(17)+"\n");

        }

        final String petIntent = getIntent().getExtras().getString("Species");

            ListView listview = (ListView) findViewById(PetDetailsId);
            PetAdaptrer petAdaptrer = new PetAdaptrer(getApplicationContext(), R.layout.activity_pet_details);
            listview.setAdapter(petAdaptrer);

        for ( i = 0; i < pet.size(); i++) {
            if (pet.get(i).getSpecies().equals(petIntent)) {

                PetDataProvider petDataProvider = new PetDataProvider(
                        pet.get(i).getImageUri(), pet.get(i).getName(), pet.get(i).getBreed());
                petAdaptrer.add(petDataProvider);

            }
        }


          final   ListView listView = (ListView) findViewById(PetDetailsId);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(PetDetailsActivity.this, BrowseActivity.class);


                    String result = (String) listView.getItemAtPosition(position).toString();
                    intent.putExtra("Id",result);

                    startActivity(intent);
                }
            });




    }

}

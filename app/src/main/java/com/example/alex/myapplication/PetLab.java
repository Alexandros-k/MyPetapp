package com.example.alex.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/19/2017.
 */

public class PetLab {

    private static PetLab sPetLab;
    static public List<Pet> mPets;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private PetLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new PetDbHelper(mContext)
                .getWritableDatabase();
        mPets = new ArrayList<>();
        Pet p1 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog", R.drawable.canis);
        Pet p2 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog",R.drawable.british_short_hair);
        Pet p3 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog",R.drawable.canis);
        Pet p4 =new Pet("jack","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog",R.drawable.colley);
        Pet p5 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog",R.drawable.maine_coon);
        Pet p6 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog",R.drawable.canis);
        Pet p7 =new Pet("nick","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog",R.drawable.lab);
        Pet p8 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog",R.drawable.ragdoll);
        Pet p9 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog",R.drawable.canis);
        Pet p10 =new Pet("rain","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog",R.drawable.husky);

        mPets.add(p1);
        mPets.add(p2);
        mPets.add(p3);
        mPets.add(p4);
        mPets.add(p5);
        mPets.add(p6);
        mPets.add(p7);
        mPets.add(p8);
        mPets.add(p9);
        mPets.add(p10);
    }

}

package com.example.alex.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.alex.myapplication.PetDbSchema.PetTable.TABLE_NAME;


/**
 * Created by Alex on 4/18/2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    Pet p1 =new Pet("kiko","1984", "male","pitbul","black","none","1238","Alex","nikaia","23432","kostas","peiraias","23423432","all good","dog","3", R.drawable.canis);

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PetManagement.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";


    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID PRIMARY KEY AUTOINCREMENT," +
                PetDbSchema.PetTable.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_DATE_OF_BIRTH + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_GENDER + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_BREED + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_COLOUR + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_DISTINGUISHING_MARKS + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_CHIP_ID + INT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_OWNER_NAME + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_OWNER_ADDRESS + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_OWNER_PHONE + INT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_VET_NAME + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_VET_ADDRESS + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_VET_PHONE + INT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_COMMENTS + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_SPECIES + TEXT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_ID + INT_TYPE + COMMA_SEP +
                PetDbSchema.PetTable.COLUMN_NAME_IMAGE_URI + INT_TYPE + COMMA_SEP + ")");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade
        // policy is to simply discard the data and start over
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);

    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private ContentValues getContentValues(Pet p1) {
        ContentValues values = new ContentValues();
        values.put(PetDbSchema.PetTable.COLUMN_NAME_NAME , p1.getName());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_DATE_OF_BIRTH , p1.getDateOfBirth());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_GENDER , p1.getGender());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_BREED, p1.getBreed());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_COLOUR, p1.getColour());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_DISTINGUISHING_MARKS , p1.getDistinguishingMarks());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_CHIP_ID, p1.getChipID());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_OWNER_NAME , p1.getOwnerName());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_OWNER_ADDRESS , p1.getOwnerAddress());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_OWNER_PHONE, p1.getOwnerPhone());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_VET_NAME, p1.getVetName());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_VET_ADDRESS, p1.getVetAddress());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_VET_PHONE, p1.getVetPhone());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_COMMENTS, p1.getComments());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_SPECIES, p1.getSpecies());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_ID, p1.getId());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_IMAGE_URI, p1.getImageUri());
        return values;
    }
    private void insertPet(Pet p) {
        SQLiteDatabase db = this .getWritableDatabase();
        ContentValues values = getContentValues(p);
        db .insert(TABLE_NAME , null , values);
    }

public Cursor getAllData(){
    SQLiteDatabase db = this .getWritableDatabase();
Cursor res =db.rawQuery("select * from" + TABLE_NAME, null);
    return res;
}

}




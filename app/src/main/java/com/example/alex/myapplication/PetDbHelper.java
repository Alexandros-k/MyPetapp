package com.example.alex.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.alex.myapplication.PetDbSchema.PetTable.TABLE_NAME;


/**
 * Created by Alex on 4/18/2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    private static final String[] PROJECTION = {
            PetDbSchema.PetTable._ID,
            PetDbSchema.PetTable.COLUMN_NAME_NAME,
            PetDbSchema.PetTable.COLUMN_NAME_DATE_OF_BIRTH,
            PetDbSchema.PetTable.COLUMN_NAME_GENDER,
            PetDbSchema.PetTable.COLUMN_NAME_BREED,
            PetDbSchema.PetTable.COLUMN_NAME_COLOUR,
            PetDbSchema.PetTable.COLUMN_NAME_DISTINGUISHING_MARKS,
            PetDbSchema.PetTable.COLUMN_NAME_CHIP_ID,
            PetDbSchema.PetTable.COLUMN_NAME_SPECIES,
            PetDbSchema.PetTable.COLUMN_NAME_COMMENTS,
            PetDbSchema.PetTable.COLUMN_NAME_IMAGE_URI,

            PetDbSchema.PetTable.COLUMN_NAME_OWNER_NAME,
            PetDbSchema.PetTable.COLUMN_NAME_OWNER_ADDRESS,
            PetDbSchema.PetTable.COLUMN_NAME_OWNER_PHONE,

            PetDbSchema.PetTable.COLUMN_NAME_VET_NAME,
            PetDbSchema.PetTable.COLUMN_NAME_VET_ADDRESS,
            PetDbSchema.PetTable.COLUMN_NAME_VET_PHONE,
    };

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PetManagement.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    private static final String SORT_ORDER = PetDbSchema.PetTable.COLUMN_NAME_NAME + " ASC";


    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (_ID " + INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
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
                PetDbSchema.PetTable.COLUMN_NAME_IMAGE_URI + INT_TYPE +")");

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
        values.put(PetDbSchema.PetTable.COLUMN_NAME_NAME, p1.getName());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_DATE_OF_BIRTH, p1.getDateOfBirth());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_GENDER, p1.getGender());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_BREED, p1.getBreed());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_COLOUR, p1.getColour());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_DISTINGUISHING_MARKS, p1.getDistinguishingMarks());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_CHIP_ID, p1.getChipID());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_OWNER_NAME, p1.getOwnerName());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_OWNER_ADDRESS, p1.getOwnerAddress());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_OWNER_PHONE, p1.getOwnerPhone());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_VET_NAME, p1.getVetName());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_VET_ADDRESS, p1.getVetAddress());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_VET_PHONE, p1.getVetPhone());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_COMMENTS, p1.getComments());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_SPECIES, p1.getSpecies());
        values.put(PetDbSchema.PetTable.COLUMN_NAME_IMAGE_URI, p1.getImageUri());
        return values;
    }

    private void insertPet(Pet p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = getContentValues(p);
        db.insert(TABLE_NAME, null, values);
    }

    /*public Cursor getAllData(){
        SQLiteDatabase db = this .getWritableDatabase();
    Cursor res =db.rawQuery("select * from" + TABLE_NAME, null);
        return res;
    }*/
    public List<Pet> getPets() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_NAME,           // The table to query
                PROJECTION,                                     // The columns to return
                null,                                    // The columns for the WHERE clause
                null,                                      // The values for the WHERE clause
                null,                                           // don't group the rows
                null,                                           // don't filter by row groups
                SORT_ORDER                                      // The sort order
        );

        List<Pet> pets = new ArrayList<>();

        int nameColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_NAME);
        int dateOfBirthColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_DATE_OF_BIRTH);
        int genderColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_GENDER);
        int breedColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_BREED);
        int colorColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_COLOUR);
        int distinguishingMarksColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_DISTINGUISHING_MARKS);
        int chipIDColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_CHIP_ID);
        int speciesColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_SPECIES);
        int commentsColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_COMMENTS);
        int imageUriColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_IMAGE_URI);
        int ownerNameColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_OWNER_NAME);
        int ownerAddressColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_OWNER_ADDRESS);
        int ownerPhoneNumberColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_OWNER_PHONE);
        int vetNameColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_VET_NAME);
        int vetAddressColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_VET_ADDRESS);
        int vetPhoneNumberColumn = cursor.getColumnIndexOrThrow(PetDbSchema.PetTable.COLUMN_NAME_VET_PHONE);

        while (cursor.moveToNext()) {
            Pet pet = new Pet(cursor.getString(nameColumn),
                    cursor.getString(dateOfBirthColumn),
                    cursor.getString(genderColumn),
                    cursor.getString(breedColumn),
                    cursor.getString(colorColumn),
                    cursor.getString(distinguishingMarksColumn),
                    cursor.getString(chipIDColumn),
                    cursor.getString(ownerNameColumn),
                    cursor.getString(ownerAddressColumn),
                    cursor.getString(ownerPhoneNumberColumn),
                    cursor.getString(vetNameColumn),
                    cursor.getString(vetAddressColumn),
                    cursor.getString(vetPhoneNumberColumn),
                    cursor.getString(commentsColumn),
                    cursor.getString(speciesColumn),
                    cursor.getInt(imageUriColumn));

            pets.add(pet);
        }

        cursor.close();

        return pets;
    }


    public int countPets() {
        SQLiteDatabase db = this.getWritableDatabase();
        String countQuery = "SELECT count(*) FROM " + PetDbSchema.PetTable.TABLE_NAME;
        Cursor mcursor = db.rawQuery(countQuery, null);
        mcursor.moveToFirst();
        return mcursor.getInt(0);
    }

    public void initDb() {
        if (countPets() == 0) {
            for (Pet pet : getPetList()) {
                insertPet(pet);
            }
        }
    }

    private List<Pet> getPetList() {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("riko", "1983", "male", "canis", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Dog", R.drawable.canis));
        pets.add(new Pet("kika", "1984", "female", "british short hair", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Cat", R.drawable.british_short_hair));
        pets.add(new Pet("lock", "1985", "male", "pitbul", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Other", R.drawable.canis));
        pets.add(new Pet("jack", "1987", "male", "colley", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Dog", R.drawable.colley));
        pets.add(new Pet("rover", "1984", "male", "maine coon", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Cat", R.drawable.maine_coon));
        pets.add(new Pet("summer", "1982", "fale", "canis", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Other", R.drawable.canis));
        pets.add(new Pet("nick", "1988", "male", "lab", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Dog", R.drawable.lab));
        pets.add(new Pet("leto", "1986", "male", "ragdoll", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Cat", R.drawable.ragdoll));
        pets.add(new Pet("kiko", "1999", "male", "canis", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Other", R.drawable.canis));
        pets.add(new Pet("rain", "1984", "male", "husky", "black", "none", "1238", "Alex", "nikaia", "23432", "kostas", "peiraias", "23423432", "all good", "Dog", R.drawable.husky));

        return pets;
    }
}




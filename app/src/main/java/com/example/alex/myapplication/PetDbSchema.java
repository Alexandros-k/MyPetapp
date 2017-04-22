package com.example.alex.myapplication;

import android.provider.BaseColumns;

/**
 * Created by Alex on 4/17/2017.
 */

public class PetDbSchema {

    public PetDbSchema() {
    }

    public static abstract class PetTable implements BaseColumns {

        public static final String TABLE_NAME = "pet";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DATE_OF_BIRTH = "date_of_birth";
        public static final String COLUMN_NAME_GENDER = "gender";
        public static final String COLUMN_NAME_BREED = "breed";
        public static final String COLUMN_NAME_COLOUR = "colour";
        public static final String COLUMN_NAME_DISTINGUISHING_MARKS = "distinguishing_marks";
        public static final String COLUMN_NAME_CHIP_ID = "chip_id";
        public static final String COLUMN_NAME_OWNER_NAME = "owner_name";
        public static final String COLUMN_NAME_OWNER_ADDRESS = "owner_address";
        public static final String COLUMN_NAME_OWNER_PHONE = "owner_phone";
        public static final String COLUMN_NAME_VET_NAME = "vet_name";
        public static final String COLUMN_NAME_VET_ADDRESS = "vet_address";
        public static final String COLUMN_NAME_VET_PHONE = "vet_phone";
        public static final String COLUMN_NAME_COMMENTS = "comments";
        public static final String COLUMN_NAME_SPECIES = "species";
        public static final String COLUMN_NAME_ID = "name_id";
        public static final String COLUMN_NAME_IMAGE_URI = "image_uri";
        public static final String TEXT_TYPE = " TEXT";
        public static final String INT_TYPE = " INTEGER";
        public static final String COMMA_SEP = ",";


    }

}

/*
    private static final String SQL_CREATE_PETS =
            "CREATE TABLE " + PetDbSchema.PetTable.TABLE_NAME + " (" +
                    PetTable._ID + INT_TYPE + "PRIMARY KEY AUTOINCREMENT," +
                    PetTable.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_DATE_OF_BIRTH + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_GENDER + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_BREED + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_COLOUR + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_DISTINGUISHING_MARKS + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_CHIP_ID + INT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_OWNER_NAME + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_OWNER_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_OWNER_PHONE + INT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_VET_NAME + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_VET_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_VET_PHONE + INT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_COMMENTS + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_SPECIES + TEXT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_ID + INT_TYPE + COMMA_SEP +
                    PetTable.COLUMN_NAME_IMAGE_URI + INT_TYPE + COMMA_SEP + " )";

    private static final String SQL_DELETE_STUDENTS =
            "DROP TABLE IF EXISTS " + PetTable.TABLE_NAME;

               private ContentValues getContentValues(PetTable p) {
            ContentValues values = new ContentValues();
            values.put(PetTable.COLUMN_NAME_NAME,"");
            values.put(PetTable.COLUMN_NAME_DATE_OF_BIRTH, "");
            values.put(PetTable.COLUMN_NAME_GENDER, "");
            values.put(PetTable.COLUMN_NAME_BREED, "");
            values.put(PetTable.COLUMN_NAME_COLOUR, "");
            values.put(PetTable.COLUMN_NAME_DISTINGUISHING_MARKS, "");
            values.put(PetTable.COLUMN_NAME_CHIP_ID, "");
            values.put(PetTable.COLUMN_NAME_OWNER_NAME, "");
            values.put(PetTable.COLUMN_NAME_OWNER_ADDRESS, "");
            values.put(PetTable.COLUMN_NAME_OWNER_PHONE, "");
            values.put(PetTable.COLUMN_NAME_VET_NAME, "");
            values.put(PetTable.COLUMN_NAME_VET_ADDRESS, "");
            values.put(PetTable.COLUMN_NAME_VET_PHONE, "");
            values.put(PetTable.COLUMN_NAME_COMMENTS, "");
            values.put(PetTable.COLUMN_NAME_SPECIES, "");
            values.put(PetTable.COLUMN_NAME_ID + INT_TYPE, "");
            values.put(PetTable.COLUMN_NAME_IMAGE_URI, "");

            return values;
        }

        private static final String TABLE_NAME = "pet";
    private static final String COLUMN_NAME_NAME = "name";
    private static final String COLUMN_NAME_DATE_OF_BIRTH = "date_of_birth";
    private static final String COLUMN_NAME_GENDER = "gender";
    private static final String COLUMN_NAME_BREED = "breed";
    private static final String COLUMN_NAME_COLOUR = "colour";
    private static final String COLUMN_NAME_DISTINGUISHING_MARKS = "distinguishing_marks";
    private static final String COLUMN_NAME_CHIP_ID = "chip_id";
    private static final String COLUMN_NAME_OWNER_NAME = "owner_name";
    private static final String COLUMN_NAME_OWNER_ADDRESS = "owner_address";
    private static final String COLUMN_NAME_OWNER_PHONE = "owner_phone";
    private static final String COLUMN_NAME_VET_NAME = "vet_name";
    private static final String COLUMN_NAME_VET_ADDRESS = "vet_address";
    private static final String COLUMN_NAME_VET_PHONE = "vet_phone";
    private static final String COLUMN_NAME_COMMENTS = "comments";
    private static final String COLUMN_NAME_SPECIES = "species";
    private static final String COLUMN_NAME_ID = "name_id";
    private static final String COLUMN_NAME_IMAGE_URI = "image_uri";
            */

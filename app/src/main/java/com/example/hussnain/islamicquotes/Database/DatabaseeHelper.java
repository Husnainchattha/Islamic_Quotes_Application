package com.example.hussnain.islamicquotes.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hussnain.islamicquotes.Ayat;
import com.example.hussnain.islamicquotes.DataBaseAyat;
import com.example.hussnain.islamicquotes.DataBaseHadith;
import com.example.hussnain.islamicquotes.DataBaseNoble;

import java.util.ArrayList;

public class DatabaseeHelper extends SQLiteOpenHelper  {
    public static final String CREATE_TABLE_AYAT =
            " CREATE TABLE " + Tables.Ayat.TABLE_NAME + " ( " +
            Tables.Ayat._ID + " TEXT PRIMARY KEY, " +
            Tables.Ayat.COLUMN_TITLE + " TEXT, " +
                    Tables.Ayat.COLUMN_TITLE1 + " TEXT )" ;
    public static final String CREATE_TABLE_NOBLE=
            " CREATE TABLE " + Tables.NobleTable.TABLE_NAME + " ( " +
                    Tables.NobleTable._ID + " TEXT PRIMARY KEY, " +
                    Tables.NobleTable.COLUMN_QUOT + " TEXT, " +
                    Tables.NobleTable.COLUMN_WRITER + " TEXT )";
    public static final String CREATE_TABLE_HADITH=
            " CREATE TABLE " + Tables.HadithTable.TABLE_NAME +" ( " +
                    Tables.HadithTable._ID + " TEXT PRIMARY KEY, " +
                    Tables.HadithTable.COLUMN_HADITH + " TEXT, " +
                    Tables.HadithTable.COLUMN_HWRITER + " TEXT )";

    public DatabaseeHelper(Context context) {
        super(context,"newsdb",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     sqLiteDatabase.execSQL(CREATE_TABLE_AYAT);
     sqLiteDatabase.execSQL(CREATE_TABLE_NOBLE);
     sqLiteDatabase.execSQL(CREATE_TABLE_HADITH);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void saveAyat(String randomayat,String randomayyat ){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Tables.Ayat.COLUMN_TITLE,randomayat);
        values.put(Tables.Ayat.COLUMN_TITLE1,randomayyat);
        db.insert(Tables.Ayat.TABLE_NAME,null,values);
        }
        public void saveNoble(String quot,String writer){
        SQLiteDatabase data=getWritableDatabase();
        ContentValues values=new ContentValues();
         values.put(Tables.NobleTable.COLUMN_QUOT,quot);
         values.put(Tables.NobleTable.COLUMN_WRITER,writer);
         data.insert(Tables.NobleTable.TABLE_NAME,null,values);
        }
        public void saveHadith(String hadith,String writer){
        SQLiteDatabase databaseb=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Tables.HadithTable.COLUMN_HADITH,hadith);
        values.put(Tables.HadithTable.COLUMN_HWRITER,writer);
        databaseb.insert(Tables.HadithTable.TABLE_NAME,null,values);
        }
        public ArrayList<DataBaseHadith>getAllHadith(){
        ArrayList<DataBaseHadith>hadiths=new ArrayList <>();
        SQLiteDatabase database=getWritableDatabase();
        String []selection={Tables.HadithTable.COLUMN_HADITH,Tables.HadithTable.COLUMN_HWRITER};
        Cursor cursor=database.query(Tables.HadithTable.TABLE_NAME,selection,null,null,null,null,null);
        while (cursor.moveToNext()){
            DataBaseHadith obj=new DataBaseHadith();
            obj.setHadith(cursor.getString(0));
            obj.setAuthor(cursor.getString(1));
            hadiths.add(obj);
        }cursor.close();
        return hadiths;
        }
        public ArrayList<DataBaseNoble>getAllNoble(){
        ArrayList<DataBaseNoble> nobles=new ArrayList <>();
        SQLiteDatabase db=getWritableDatabase();
        String [] selection={Tables.NobleTable.COLUMN_QUOT,Tables.NobleTable.COLUMN_WRITER};
        Cursor cursor=db.query(Tables.NobleTable.TABLE_NAME,selection,null,null,null,null,null);
        while (cursor.moveToNext()){
         DataBaseNoble noble=new DataBaseNoble();
         noble.setQuotby(cursor.getString(0));
         noble.setWriterby(cursor.getString(1));
         nobles.add(noble);
        }
        cursor.close();
        return nobles;
        }
    public ArrayList<DataBaseAyat> getAllAyat(){
        ArrayList<DataBaseAyat> ayat=new ArrayList <>();
        SQLiteDatabase db=getWritableDatabase();

        String[] selection = {Tables.Ayat.COLUMN_TITLE,Tables.Ayat.COLUMN_TITLE1};

        Cursor cursor = db.query(Tables.Ayat.TABLE_NAME, selection, null, null, null, null,null);
        while (cursor.moveToNext()) {
                        DataBaseAyat ayat1 = new DataBaseAyat();
                        ayat1.setRandomayat(cursor.getString(0));
                        ayat1.setAyat(cursor.getString(1));
                        ayat.add(ayat1);
                    }
                cursor.close();
              return ayat;
    } public DataBaseNoble getDataBaseNobleWhereTitle(String quot,String writer){
        SQLiteDatabase db=getWritableDatabase();
        String[]column={Tables.NobleTable.COLUMN_QUOT,Tables.NobleTable.COLUMN_WRITER};
        String selection=Tables.NobleTable.COLUMN_QUOT + " =?"+Tables.NobleTable.COLUMN_WRITER + " =?";
        String[]selectionArgs={quot,writer};

        Cursor cursor = db.query(Tables.NobleTable.TABLE_NAME, column, selection, selectionArgs,null, null,null,null);
        if (cursor.moveToNext()) {
            DataBaseNoble noble=new DataBaseNoble(cursor.getString(0),cursor.getString(1));
            cursor.close();
            return noble;
        }
        return null;
    }
    public DataBaseAyat getDataBaseAyatWhereTitle(String title,String title1){
        SQLiteDatabase db=getWritableDatabase();
        String[]column={Tables.Ayat.COLUMN_TITLE,Tables.Ayat.COLUMN_TITLE1};
        String selection=Tables.Ayat.COLUMN_TITLE + " =?"+Tables.Ayat.COLUMN_TITLE1 + " =?";
        String[]selectionArgs={title,title1};

        Cursor cursor = db.query(Tables.Ayat.TABLE_NAME, column, selection, selectionArgs,null, null,null,null);
             if (cursor.moveToNext()) {
                        DataBaseAyat ayat=new DataBaseAyat(cursor.getString(0),cursor.getString(1));
                        cursor.close();
            return ayat;
                  }
              return null;
    }
    public DataBaseHadith getDataBaseHadithWhereTitle(String title,String title1){
        SQLiteDatabase db=getWritableDatabase();
        String[]column={Tables.HadithTable.COLUMN_HADITH,Tables.HadithTable.COLUMN_HWRITER};
        String selection=Tables.HadithTable.COLUMN_HADITH + " =?"+Tables.HadithTable.COLUMN_HWRITER + " =?";
        String[]selectionArgs={title,title1};

        Cursor cursor = db.query(Tables.HadithTable.TABLE_NAME, column, selection, selectionArgs,null, null,null,null);
        if (cursor.moveToNext()) {
            DataBaseHadith hadith=new DataBaseHadith(cursor.getString(0),cursor.getString(1));
            cursor.close();
            return hadith;
        }
        return null;
    }
}

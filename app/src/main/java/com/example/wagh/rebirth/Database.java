package com.example.wagh.rebirth;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by wagh on 7/5/17.
 */

public class Database extends SQLiteOpenHelper {


    //SQLiteDatabase database;

    String query = "";

    private static final String databasename = "weather";

    String tablename = "records";

    private static final int DATABASEVERSION = 1;

    //column names

    String base = "base";

    String dt = "dt";

    String id = "id";

    String name = "name";

    String cod = "cod";

    String lon = "lon";

    String lat = "lat";

    String id1 = "id1";

    String main = "main";

    String description = "description";

    String temp = "temp";

    String pressure = "pressure";

    String humidity = "humidity";

    String temp_min = "temp_min";

    String temp_max = "temp_max";


    Database(Context context) {
        super(context, databasename, null, DATABASEVERSION);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        ///actually need to see why database is not working like openorcreate database vala line is not there so

        // problems astil check database opening part rest of the part maybe works:P

        //this.database=db;

        //database=SQLiteDatabase.openOrCreateDatabase(databasename,null);

        query = "CREATE TABLE " + tablename + "(" + base + " VARCHAR2," + dt + " VARCHAR2," + id + " VARCHAR2," + name + " VARCHAR2," + cod + " VARCHAR2," + lon + " VARCHAR2," + lat + " VARCHAR2," + id1 + " VARCHAR2," + main + " VARCHAR2," + description + " VARCHAR2," + temp + " VARCHAR2," + pressure + " VARCHAR2," + humidity + " VARCHAR2," + temp_min + " VARCHAR2," + temp_max + " VARCHAR2)";

        db.execSQL(query);

        Log.d("Success", "Connection");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(SQLiteDatabase db,String dbase, String ddt, String did, String dname, String dcod, String dlon, String dlat, String dtemp, String dpressure, String dhumidity, String dtemp_max, String dtemp_min, String did1, String dmain, String ddescription) {
        try {
            db = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();

            contentValues.put(base, dbase);

            contentValues.put(dt, ddt);

            contentValues.put(id, did);

            contentValues.put(name, dname);

            contentValues.put(cod, dcod);

            contentValues.put(lon, dlon);

            contentValues.put(lat, dlat);

            contentValues.put(temp, dtemp);

            contentValues.put(pressure, dpressure);

            contentValues.put(humidity, dhumidity);

            contentValues.put(temp_max, dtemp_max);

            contentValues.put(temp_min, dtemp_min);

            contentValues.put(id1, did1);

            contentValues.put(main, dmain);

            contentValues.put(description, ddescription);

            db.insert(tablename, null, contentValues);

            db.close();

        } catch (Exception e) {
            Log.e("ERROR", "INSERT", e);
        }


    }

}

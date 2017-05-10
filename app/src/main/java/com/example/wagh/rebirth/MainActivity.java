package com.example.wagh.rebirth;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;


public class MainActivity extends AppCompatActivity {


    private TextView textView;

    private Button b1;


    Context context;

    Database bb;

    private static final String databasename = "weather.db";


    String gold = null;

    String finaldata="";

    Object anyObject = null;

    ServerCalls sc;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getBaseContext(),"Welcome back!!",Toast.LENGTH_LONG).show();


        //database things

        context=getApplicationContext();

        bb=new Database(this);


        //*end of database things

        textView=(TextView)findViewById(R.id.texty);

        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sc = new ServerCalls();

                sc.execute(anyObject, gold,MainActivity.this);        ////some issues need to check from hereQ!!!!!!!!!!!

                //finaldata=sc.data2;

                //textView.setText(finaldata);


            }
        });

       // finaldata=sc.data2;

        //JSONToString(finaldata);

    }





     @RequiresApi(api = Build.VERSION_CODES.KITKAT)
     void JSONToString(String rock)
     {


         if(!(rock.equals("No Data Found")))
         {
             try
             {
                 JSONObject jsonObject=new JSONObject(rock);

                 JSONObject jsoncoord=jsonObject.getJSONObject("coord");

                 JSONArray jsonweather=jsonObject.getJSONArray("weather");      //all test case are performed for JSON

                 JSONObject  jsonmain=jsonObject.getJSONObject("main");

                 JSONObject  jsonwind=jsonObject.getJSONObject("wind");

                 JSONObject  jsonclouds=jsonObject.getJSONObject("clouds");

                 JSONObject  jsonsys=jsonObject.getJSONObject("sys");



                 String base=jsonObject.getString("base");

                 String dt=jsonObject.getString("dt");

                 String id=jsonObject.getString("id");

                 String name=jsonObject.getString("name");

                 String cod=jsonObject.getString("cod");

                 String id1="";

                 String main="";

                 String description="";

                 String lon=jsoncoord.getString("lon");

                 String lat=jsoncoord.getString("lat");


                 for (int i=0;i<jsonweather.length();i++)
                 {
                     JSONObject jsonweatherarray=(JSONObject)jsonweather.get(i);

                     id1=jsonweatherarray.getString("id");

                     main=jsonweatherarray.getString("main");

                     description=jsonweatherarray.getString("description");
                 }

                 String temp=jsonmain.getString("temp");

                 String pressure=jsonmain.getString("pressure");

                 String humidity=jsonmain.getString("humidity");

                 String temp_min=jsonmain.getString("temp_min");

                 String temp_max=jsonmain.getString("temp_max");


                 Log.d("Data Congo",name);

                 finaldata+="|base="+base+"|dt="+dt+"|id="+id+"|name="+name+"|cod="+cod+"|lon="+lon+"|lat="+lat+"|temp="+temp+"|pressure="+pressure+"|humidity="+humidity+"|temp max="+temp_max+"|temp min="+temp_min;

                 finaldata+="|id="+id1+"|main="+main+"|description="+description;

                 Log.d("Data Congo",finaldata);

                 //database things


                 SQLiteDatabase databasemain =null;


                     databasemain=openOrCreateDatabase(databasename,MODE_PRIVATE,null);

                 //context=getApplicationContext();

                //java.lang.NullPointerException: Attempt to invoke virtual method 'android.database.sqlite.SQLiteDatabase android.content.Context.openOrCreateDatabase(java.lang.String, int, android.database.sqlite.SQLiteDatabase$CursorFactory)' on a null object reference


                 //still error on this line

                 bb.onCreate(databasemain);

                 bb.insert(databasemain,base,dt,id,name,cod,lon,lat,temp,pressure,humidity,temp_max,temp_min,id1,main,description);


                textView.setText(name);

                // textView.setText(finaldata);



             }
             catch (Exception e)
             {
                 Log.e("ERROR","JSONTOSTRING",e);

             }

         }
         else
         {
             //textView.setText(finaldata);
         }

         //textView.setText(finaldata);
     }




        //Linking of other classes



    }


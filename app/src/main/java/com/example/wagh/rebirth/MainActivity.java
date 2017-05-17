package com.example.wagh.rebirth;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;


public class MainActivity extends AppCompatActivity {


//   private TextView textView;    //used in 1st version

    private Button b1;

    RecyclerView recyclerViewMainRecyclerView;  //for the 16th may version

    Context context;

    Database bb;

    private static final String databasename = "weather.db";


    String gold = null;

//    String finaldata="";  //used in 1st version

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

        //Binding stuff

        recyclerViewMainRecyclerView=(RecyclerView)findViewById(R.id.rvlist);

        //textView=(TextView)findViewById(R.id.texty);   //used in 1st version

        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idvalue=1272423;

                sc = new ServerCalls(idvalue);

                sc.execute(anyObject, gold,MainActivity.this);        ////some issues need to check from hereQ!!!!!!!!!!!

                //finaldata=sc.data2;

                //textView.setText(finaldata);


            }
        });

       // finaldata=sc.data2;

        //JSONToString(finaldata);

        //Recyclerview stuff

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);

        recyclerViewMainRecyclerView.setLayoutManager(layoutManager);

        AdapterClassMainActivityRecycler adapterClassMainActivityRecycler=new AdapterClassMainActivityRecycler();

        recyclerViewMainRecyclerView.setAdapter(adapterClassMainActivityRecycler);

      //***********************************************set on click for recycler :)

    }







    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    void DATAbase(String rock)
    {
        JsonToString json=new JsonToString();

        weather zz=json.JSONToString(rock);

        if (zz!=null)
        {

            try
            {
                //database things


                SQLiteDatabase databasemain =null;


                databasemain=openOrCreateDatabase(databasename,MODE_PRIVATE,null);

                //context=getApplicationContext();

                //java.lang.NullPointerException: Attempt to invoke virtual method 'android.database.sqlite.SQLiteDatabase android.content.Context.openOrCreateDatabase(java.lang.String, int, android.database.sqlite.SQLiteDatabase$CursorFactory)' on a null object reference


                //still error on this line

                bb.onCreate(databasemain);

                bb.insert(databasemain,zz.getBase(),zz.getDt(),zz.getId(),zz.getName(),zz.getCod(),zz.getLon(),zz.getLat(),zz.getTemp(),zz.getPressure(),zz.getHumidity(),zz.getTemp_max(),zz.getTemp_min(),zz.getId1(),zz.getMain(),zz.getDescription());

                String golden=bb.extract(databasemain);

                Intent intent=new Intent(MainActivity.this,alldataRecyclerview.class);

                intent.putExtra("GOLDENDATA",golden);

                startActivity(intent);


                //textView.setText(golden);

                // textView.setText(finaldata);

            }
            catch (Exception e)
            {
                Log.e("Error","DatabaseMAINACTIVITY",e);
            }
        }
    }


}


package com.example.wagh.rebirth;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by wagh on 13/5/17.
 */

public class alldataRecyclerview extends Activity {


    RecyclerView recyclerView;

//    CardView cardView;

    String[] sorteddata;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alldata);


        String sortdata=getIntent().getStringExtra("GOLDENDATA");


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

        String[] colname={base,dt,id,name,cod,lon,lat,id1,main,description,temp,pressure,humidity,temp_min,temp_max};

        //******************************************************* STring things start

            if (sortdata!=null)
            {
                sortdata.trim();
                sorteddata=sortdata.split("%");
            }


        //*******************************************************String things end


        recyclerView=(RecyclerView)findViewById(R.id.recycler123);


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter;

        adapter=new AdapterRecycler(colname,sorteddata);

        recyclerView.setAdapter(adapter);




    }
}

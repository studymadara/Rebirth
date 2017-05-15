package com.example.wagh.rebirth;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by wagh on 13/5/17.
 */

public class JsonToString {


    weather one=new weather();



    String finaldata="";


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    weather JSONToString(String rock)
    {


        if(!(rock.equals("No Data Found")))
        {
            try
            {
                JSONObject jsonObject=new JSONObject(rock);

                JSONObject jsoncoord=jsonObject.getJSONObject("coord");

                JSONArray jsonweather=jsonObject.getJSONArray("weather");      //all test case are performed for JSON

                JSONObject  jsonmain=jsonObject.getJSONObject("main");

                /*JSONObject  jsonwind=jsonObject.getJSONObject("wind");

                JSONObject  jsonclouds=jsonObject.getJSONObject("clouds");

                JSONObject  jsonsys=jsonObject.getJSONObject("sys");
*/


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


                one.setBase(base);

                one.setDt(dt);

                one.setId(id);;

                one.setName(name);;

                one.setCod(cod);;

                one.setId1(id1);

                one.setMain(main);

                one.setDescription(description);

                one.setLon(lon);

                one.setLat(lat);;

                one.setTemp(temp);;

                one.setCod(cod);

                one.setHumidity(humidity);

                one.setPressure(pressure);

                one.setTemp_max(temp_max);

                one.setTemp_min(temp_min);

                return one;



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

        return one;
        //textView.setText(finaldata);
    }


}

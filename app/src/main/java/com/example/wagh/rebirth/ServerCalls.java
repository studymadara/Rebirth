package com.example.wagh.rebirth;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wagh on 5/5/17.
 */

public class ServerCalls extends AsyncTask<Object,Void,String> {

    URL url=null;

    HttpURLConnection httpURLConnection=null;

    BufferedReader bufferedReader;

    String APIKEYWEATHER="6230eae0343873e23bdb3c4a3f464a76";

    String API2="600aa0c365273fef20eba556eed903a3";

    int idvalue;

    String data1,data2="";

    String send;

    MainActivity mm;

    ServerCalls(int cityid)
    {
        this.idvalue=cityid;
    }

    @Override
    protected String doInBackground(Object[] params) {


        try
        {
            url=new URL("http://api.openweathermap.org/data/2.5/weather?id="+idvalue+"&appid="+API2);

            httpURLConnection=(HttpURLConnection)url.openConnection();

            httpURLConnection.setDoOutput(true);

            httpURLConnection.setRequestMethod("GET");

          //  httpURLConnection.setRequestProperty("id",idvalue);

           // httpURLConnection.setRequestProperty("APIID",APIKEYWEATHER);

            //httpURLConnection.setRequestProperty("appid",API2);


        }
        catch(Exception e)
        {

            Log.e("Error sending request",">",e);
        }

        try
        {

            String tp=httpURLConnection.getResponseMessage();

            Log.e("RESPONSE MESSAGE",tp);

            bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            while ((data1=bufferedReader.readLine())!=null)
            {
                data2+=data1;
            }

            this.mm=(MainActivity)params[2];

            //return data2;
        }
        catch (Exception e)
        {
            Log.e("PRoblem in reception",">>",e);

        }



        return data1="";
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void onPostExecute(String s) {



        mm.DATAbase(data2);


    }
}

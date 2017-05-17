package com.example.wagh.rebirth;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wagh on 16/5/17.
 */

public class AdapterClassMainActivityRecycler extends RecyclerView.Adapter<AdapterClassMainActivityRecycler.ViewHolder>
{

    ArrayList<DataOFCITY> citynames;

    DataOFCITY dd;

    int clickCityID;

    AdapterClassMainActivityRecycler()
    {
        String[] names={"Dombivli","Thane","Mumbai","Navi Mumbai"};

        int[] id={1272423,5557906,1275339,6619347};

        citynames=new ArrayList<DataOFCITY>();

        for (int i=0;i<names.length;i++)
        {
            DataOFCITY dd=new DataOFCITY();

            dd.setCityname(names[i]);

            dd.setCityid(id[i]);

            citynames.add(dd);
        }


    }



    @Override
    public AdapterClassMainActivityRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.alldatarecyclercontent,null);

        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(AdapterClassMainActivityRecycler.ViewHolder holder, int position)
    {

        dd=citynames.get(position);

        holder.tv1City.setText(dd.getCityname());

    }

    @Override
    public int getItemCount()
    {
        return citynames.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView tv1City;

        ViewHolder(View v)
        {
            super(v);

            v.setOnClickListener(this);             //onclicklistener much needed

            tv1City =(TextView)v.findViewById(R.id.tvheading);

        }


        //this is how onclicked is used


        @Override
        public void onClick(View v) {

            //Toast.makeText(v.getContext(),""+getAdapterPosition(),Toast.LENGTH_LONG).show();

            dd=citynames.get(getAdapterPosition());

            Toast.makeText(v.getContext(),"City "+dd.getCityname(),Toast.LENGTH_LONG).show();

            clickCityID=dd.getCityid();

            ServerCalls serverCalls=new ServerCalls(clickCityID);

            serverCalls.execute();

        }
    }
}

package com.example.wagh.rebirth;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wagh on 16/5/17.
 */

public class AdapterClassMainActivityRecycler extends RecyclerView.Adapter<AdapterClassMainActivityRecycler.ViewHolder>
{

    ArrayList<DataOFCITY> citynames;

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

        DataOFCITY dd=citynames.get(position);

        holder.tv1City.setText(dd.getCityname());

    }

    @Override
    public int getItemCount()
    {
        return citynames.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv1City;

        ViewHolder(View v)
        {
            super(v);

            tv1City =(TextView)v.findViewById(R.id.tvheading);

        }
    }
}

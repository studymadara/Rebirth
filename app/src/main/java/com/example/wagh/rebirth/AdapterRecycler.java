package com.example.wagh.rebirth;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wagh on 15/5/17.
 */

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder> {

    String[] adapcolname;

    String[] adapsubname;

    int co=0;

    int cosub=0;


    AdapterRecycler(String[] colname,String[] subname)
    {
        this.adapcolname=colname;

        this.adapsubname=subname;
    }



    @Override
    public AdapterRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.alldatarecyclercontent,null);

        ViewHolder ViewHolder=new ViewHolder(v);

        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterRecycler.ViewHolder holder, int position)
    {

/*
        if (co>adapcolname.length)
        {
            co=0;
            holder.tv1head.setText(adapcolname[co]);
            co++;
        }
        else if(position<adapcolname.length)
        {
            holder.tv1head.setText(adapcolname[position]);
            co++;
        }*/

            holder.tv1head.setText(adapcolname[position]);

           holder.tv2subpara.setText(adapsubname[position]);


        //holder.tv2subpara.setText(adapsubname[position]);
    }

    @Override
    public int getItemCount()
    {

        return adapsubname.length;
    }


    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv1head,tv2subpara;

        ViewHolder(View view)
        {
            super(view);

            tv1head=(TextView)view.findViewById(R.id.tvheading);

            tv2subpara=(TextView)view.findViewById(R.id.tvpara);


        }
    }
}

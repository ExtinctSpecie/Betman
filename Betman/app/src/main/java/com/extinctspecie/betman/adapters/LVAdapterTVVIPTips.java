package com.extinctspecie.betman.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Fonts;
import com.extinctspecie.betman.models.TodayItem;
import com.extinctspecie.betman.models.VIPTipsItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WorkSpace on 5/3/2017.
 */

public class LVAdapterTVVIPTips extends BaseAdapter
{
    private  List<VIPTipsItem> vipTipsItems;
    private Context context;
    private LayoutInflater layoutInflater;
    private VIPTipsItem item ;


    public LVAdapterTVVIPTips(Context context , List<VIPTipsItem> vipTipsItems)
    {
        this.vipTipsItems = vipTipsItems;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return vipTipsItems.size();
    }

    @Override
    public Object getItem(int i) {
        return vipTipsItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        final LVAdapterTVToday.ViewHolder viewHolder;


        if(view==null)
        {
            TextView tvTemp;
            viewHolder = new LVAdapterTVToday.ViewHolder();
            view = layoutInflater.inflate(R.layout.lv_adapter_tv_today,null);
            viewHolder.tvTeamOne = (TextView) view.findViewById(R.id.tvTeamOne);
            viewHolder.tvTeamOne.setTypeface(Fonts.getSFDiegoSans());

            viewHolder.tvTeamTwo = (TextView) view.findViewById(R.id.tvTeamTwo);
            viewHolder.tvTeamTwo.setTypeface(Fonts.getSFDiegoSans());

            tvTemp = (TextView) view.findViewById(R.id.tvVSHelper);
            tvTemp.setTypeface(Fonts.getSFDiegoSans());

            viewHolder.tvPrediction = (TextView) view.findViewById((R.id.tvPrediction));
            viewHolder.tvPrediction.setTypeface(Fonts.getSFDiegoSans());

            viewHolder.tvOdd = (TextView) view.findViewById((R.id.tvOdd));
            viewHolder.tvOdd.setTypeface(Fonts.getSFDiegoSans());

            viewHolder.tvTime = (TextView) view.findViewById(R.id.tvTime);
            viewHolder.tvTime.setTypeface(Fonts.getSFDiegoSans());

            //tvTemp = (TextView) view.findViewById(R.id.tvOddSymbol);
            //tvTemp.setTypeface(Fonts.getSFDiegoSans());

            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (LVAdapterTVToday.ViewHolder) view.getTag();
        }

       // item = todayItems.get(position);

        viewHolder.tvTeamOne.setText(item.getTeamOne());

        viewHolder.tvTeamTwo.setText(item.getTeamTwo());

        viewHolder.tvPrediction.setText(item.getPrediction());

        viewHolder.tvOdd.setText(item.getOdd());

        //viewHolder.tvTime.setText(item.getTimeOfGame().substring(11,16));




        return view;
    }
    static class ViewHolder
    {
        TextView tvTeamOne;
        TextView tvTeamTwo;
        TextView tvTime;
        TextView tvPrediction;
        TextView tvOdd;
    }
}

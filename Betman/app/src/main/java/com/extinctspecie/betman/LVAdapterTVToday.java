package com.extinctspecie.betman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.extinctspecie.betman.helpers.Fonts;
import com.extinctspecie.betman.models.TodayItem;
import java.util.List;


/**
 * Created by WorkSpace on 5/1/2017.
 */
// LVAdapterTVToday stands for
// List View Adapter For Tab View Today
public class LVAdapterTVToday extends BaseAdapter
{
    private Context context;
    private List<TodayItem> todayItems;
    private LayoutInflater layoutInflater;
    private TodayItem item ;

    public LVAdapterTVToday(Context context , List<TodayItem> todayItems)
    {
        this.todayItems = todayItems;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount()
    {
        return todayItems.size();
    }

    @Override
    public Object getItem(int position)
    {
        return todayItems.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        final ViewHolder viewHolder;


        if(view==null)
        {
            TextView tvTemp;
            viewHolder = new ViewHolder();
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
            viewHolder = (ViewHolder) view.getTag();
        }

        item = todayItems.get(position);

        viewHolder.tvTeamOne.setText(item.getTeam1());

        viewHolder.tvTeamTwo.setText(item.getTeam2());

        viewHolder.tvPrediction.setText(item.getPrediction());

        viewHolder.tvOdd.setText(item.getOdd());

        viewHolder.tvTime.setText(item.getTime_of_the_game().substring(11,16));

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
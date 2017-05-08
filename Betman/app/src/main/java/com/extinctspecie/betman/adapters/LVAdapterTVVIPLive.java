package com.extinctspecie.betman.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Fonts;
import com.extinctspecie.betman.models.VIPLiveItem;

import java.util.List;

/**
 * Created by WorkSpace on 5/6/2017.
 */

public class LVAdapterTVVIPLive extends BaseAdapter
{
    private List<VIPLiveItem> vipLiveItems;
    private Context context;
    private LayoutInflater layoutInflater;
    private VIPLiveItem item ;


    public LVAdapterTVVIPLive(Context context , List<VIPLiveItem> vipTipsItems)
    {
        this.vipLiveItems = vipTipsItems;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return vipLiveItems.size();
    }

    @Override
    public Object getItem(int i) {
        return vipLiveItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final LVAdapterTVVIPLive.ViewHolder viewHolder;


        if(view==null)
        {
            TextView tvTemp;
            viewHolder = new LVAdapterTVVIPLive.ViewHolder();
            view = layoutInflater.inflate(R.layout.lv_adapter_tv_vip_live,null);


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


            //tvTemp = (TextView) view.findViewById(R.id.tvOddSymbol);
            //tvTemp.setTypeface(Fonts.getSFDiegoSans());

            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (LVAdapterTVVIPLive.ViewHolder) view.getTag();
        }

        item = vipLiveItems.get(i);

        viewHolder.tvTeamOne.setText(item.getTeamOne());

        viewHolder.tvTeamTwo.setText(item.getTeamTwo());

        viewHolder.tvPrediction.setText(item.getPrediction());

        viewHolder.tvOdd.setText(item.getOdd());




        if(i % 2 == 1)
            view.setAlpha(0.8f);

        return view;
    }
    static class ViewHolder
    {
        TextView tvTeamOne;
        TextView tvTeamTwo;
        TextView tvPrediction;
        TextView tvOdd;
    }
}

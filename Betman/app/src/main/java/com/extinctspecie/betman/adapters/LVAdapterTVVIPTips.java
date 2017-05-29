package com.extinctspecie.betman.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Fonts;
import com.extinctspecie.betman.models.TodayItem;
import com.extinctspecie.betman.models.VIPLiveItem;
import com.extinctspecie.betman.models.VIPTipsItem;

import java.io.IOException;
import java.io.InputStream;
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
        final LVAdapterTVVIPTips.ViewHolder viewHolder;


        if(view==null)
        {
            TextView tvTemp;
            viewHolder = new LVAdapterTVVIPTips.ViewHolder();
            view = layoutInflater.inflate(R.layout.lv_adapter_tv_vip_tips,null);


            viewHolder.tvTeamOne = (TextView) view.findViewById(R.id.tvTeamOne);
            viewHolder.tvTeamOne.setTypeface(Fonts.getFavFont());

            viewHolder.tvTeamTwo = (TextView) view.findViewById(R.id.tvTeamTwo);
            viewHolder.tvTeamTwo.setTypeface(Fonts.getFavFont());

            tvTemp = (TextView) view.findViewById(R.id.tvVSHelper);
            tvTemp.setTypeface(Fonts.getFavFont());

            viewHolder.tvPrediction = (TextView) view.findViewById((R.id.tvPrediction));
            viewHolder.tvPrediction.setTypeface(Fonts.getFavFont());

            viewHolder.tvOdd = (TextView) view.findViewById((R.id.tvOdd));
            viewHolder.tvOdd.setTypeface(Fonts.getFavFont());

            viewHolder.tvTime = (TextView) view.findViewById(R.id.tvTime);
            viewHolder.tvTime.setTypeface(Fonts.getFavFont());

            viewHolder.imgFirstBall = (ImageView) view.findViewById(R.id.lvImgFirstBallVIPTipsTab);
            viewHolder.imgSecondBall = (ImageView) view.findViewById(R.id.lvImgSecondBallVIPTipsTab);

            viewHolder.imgFirstFlag = (ImageView) view.findViewById(R.id.lvImgFirstFlagVIPTipsTab);
            viewHolder.imgSecondFlag = (ImageView) view.findViewById(R.id.lvImgSecondFlagVIPTipsTab);

            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (LVAdapterTVVIPTips.ViewHolder) view.getTag();
        }

        item = vipTipsItems.get(i);

        viewHolder.tvTeamOne.setText(item.getTeamOne());

        viewHolder.tvTeamTwo.setText(item.getTeamTwo());

        viewHolder.tvPrediction.setText(item.getPrediction());

        viewHolder.tvOdd.setText(item.getOdd());

        viewHolder.tvTime.setText(item.getTimeOfGame().substring(11,16));

        if(item.getMatchType().equals("Football"))
        {
            viewHolder.imgFirstBall.setImageResource(R.mipmap.football_icon);
            viewHolder.imgSecondBall.setImageResource(R.mipmap.football_icon);
        }
        else
        {
            viewHolder.imgFirstBall.setImageResource(R.mipmap.basketball_icon);
            viewHolder.imgSecondBall.setImageResource(R.mipmap.basketball_icon);
        }

        if(item.getTeamOneCountry() != null)
        {
            viewHolder.imgFirstFlag.setImageDrawable(getFlag(item.getTeamOneCountry()));

            if(item.getTeamTwoCountry() == null || item.getTeamTwoCountry().equals(""))
            {
                viewHolder.imgSecondFlag.setImageDrawable(getFlag(item.getTeamOneCountry()));
            }
            else
            {
                viewHolder.imgSecondFlag.setImageDrawable(getFlag(item.getTeamTwoCountry()));
            }
        }

        if(i % 2 == 1)
            view.setAlpha(0.8f);

        return view;
    }
    private Drawable getFlag(String isoName) {

        try {
            String fileName = "flags_iso/"+isoName.toLowerCase() + ".png";
            InputStream ims = null;
            ims = context.getAssets().open(fileName);
            Drawable d = Drawable.createFromStream(ims, null);
            ims.close();
            return d;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    static class ViewHolder
    {
        TextView tvTeamOne;
        TextView tvTeamTwo;
        TextView tvTime;
        TextView tvPrediction;
        TextView tvOdd;
        ImageView imgFirstBall;
        ImageView imgSecondBall;
        ImageView imgFirstFlag;
        ImageView imgSecondFlag;
    }
    public void updateData(List<VIPTipsItem> newTodayItems) {
        vipTipsItems = newTodayItems;
        notifyDataSetChanged();
    }
}

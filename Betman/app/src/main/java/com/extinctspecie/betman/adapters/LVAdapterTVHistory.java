package com.extinctspecie.betman.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Fonts;
import com.extinctspecie.betman.models.HistoryItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by WorkSpace on 5/4/2017.
 */

public class LVAdapterTVHistory extends BaseAdapter {

    private Context context;
    private List<HistoryItem> historyItems;
    private LayoutInflater layoutInflater;
    private HistoryItem item;

    public LVAdapterTVHistory(Context context, List<HistoryItem> historyItems) {
        this.historyItems = historyItems;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return historyItems.size();
    }

    @Override
    public Object getItem(int i) {
        return historyItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;


        if (view == null) {
            TextView tvTemp;
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.lv_adapter_tv_history, null);
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

            viewHolder.tvDate = (TextView) view.findViewById(R.id.tvDate);
            viewHolder.tvDate.setTypeface(Fonts.getFavFont());


            viewHolder.tvFinalScore = (TextView) view.findViewById(R.id.tvFinalScore);

            viewHolder.llHistoryItem = (LinearLayout) view.findViewById(R.id.llHistoryItem);

            viewHolder.imgFirstBall = (ImageView) view.findViewById(R.id.lvImgFirstBallHistoryTab);
            viewHolder.imgSecondBall = (ImageView) view.findViewById(R.id.lvImgSecondBallHistoryTab);

            viewHolder.imgFlag = (ImageView) view.findViewById(R.id.lvImgFlagHistoryTab);


            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        item = historyItems.get(position);

        viewHolder.tvTime.setText(item.getTimeOfGame().substring(11, 16));

        viewHolder.tvDate.setText(item.getDateOfGame().replace("-", "/"));

        viewHolder.tvTeamOne.setText(item.getTeamOne());

        viewHolder.tvTeamTwo.setText(item.getTeamTwo());

        viewHolder.tvPrediction.setText(item.getPrediction());

        viewHolder.tvOdd.setText(item.getOdd());

        viewHolder.tvFinalScore.setText(item.getFinalScore());

        if (item.getMatchType().equals("Football")) {
            viewHolder.imgFirstBall.setImageResource(R.mipmap.football_icon);
            viewHolder.imgSecondBall.setImageResource(R.mipmap.football_icon);
        } else {
            viewHolder.imgFirstBall.setImageResource(R.mipmap.basketball_icon);
            viewHolder.imgSecondBall.setImageResource(R.mipmap.basketball_icon);
        }


        if (item.getResult().equals("true")) {
            viewHolder.llHistoryItem.setBackgroundColor((context.getResources().getColor(R.color.historyWonGreen)));
        }
        if (item.getResult().equals("false")) {
            viewHolder.llHistoryItem.setBackgroundColor((context.getResources().getColor(R.color.predictionFailed)));
        }

        if(item.getTeamOneCountry() != null)
        {
            viewHolder.imgFlag.setImageDrawable(getFlag(item.getTeamOneCountry()));

//            if(item.getTeamTwoCountry() == null || item.getTeamTwoCountry().equals(""))
//            {
//                viewHolder.imgFlag.setBackground(getFlag(item.getTeamOneCountry()));
//            }
//            else
//            {
//                viewHolder.imgFlag.setBackground(getFlag(item.getTeamTwoCountry()));
//            }
        }

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
    static class ViewHolder {
        TextView tvTeamOne;
        TextView tvTeamTwo;
        TextView tvTime;
        TextView tvPrediction;
        TextView tvOdd;
        TextView tvDate;
        TextView tvFinalScore;
        ImageView imgFirstBall;
        ImageView imgSecondBall;
        ImageView imgFlag;
        LinearLayout llHistoryItem;
    }

    public void updateData(List<HistoryItem> newTodayItems) {
        historyItems = newTodayItems;
        notifyDataSetChanged();
    }
}

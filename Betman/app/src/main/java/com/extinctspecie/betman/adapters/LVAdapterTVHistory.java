package com.extinctspecie.betman.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Fonts;
import com.extinctspecie.betman.models.HistoryItem;

import java.util.List;

/**
 * Created by WorkSpace on 5/4/2017.
 */

public class LVAdapterTVHistory extends BaseAdapter
{

    private Context context;
    private List<HistoryItem> historyItems;
    private LayoutInflater layoutInflater;
    private HistoryItem item ;

    public LVAdapterTVHistory(Context context , List<HistoryItem> historyItems)
    {
        this.historyItems = historyItems;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;


        if(view==null)
        {
            TextView tvTemp;
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.lv_adapter_tv_history,null);
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

            viewHolder.tvDate = (TextView) view.findViewById(R.id.tvDate);
            viewHolder.tvDate.setTypeface(Fonts.getSFDiegoSans());

            viewHolder.tvResult = (TextView) view.findViewById(R.id.tvResult);
            viewHolder.tvResult.setTypeface(Fonts.getSFDiegoSans());

            viewHolder.tvFinalScore = (TextView) view.findViewById(R.id.tvFinalScore);
            viewHolder.tvFinalScore.setTypeface(Fonts.getSFDiegoSans());

            //tvTemp = (TextView) view.findViewById(R.id.tvOddSymbol);
            //tvTemp.setTypeface(Fonts.getSFDiegoSans());

            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }

        item = historyItems.get(position);

        viewHolder.tvTime.setText(item.getTimeOfGame().substring(11,16));

        viewHolder.tvDate.setText(item.getDateOfGame());

        viewHolder.tvTeamOne.setText(item.getTeamOne());

        viewHolder.tvTeamTwo.setText(item.getTeamTwo());

        viewHolder.tvPrediction.setText(item.getPrediction());

        viewHolder.tvOdd.setText(item.getOdd());

        viewHolder.tvFinalScore.setText(item.getFinalScore());

        viewHolder.tvResult.setText(item.getResult());

//        viewHolder.tvTime.setText(item.getTimeOfGame().substring(11,16));

        return view;
    }
    static class ViewHolder
    {
        TextView tvTeamOne;
        TextView tvTeamTwo;
        TextView tvTime;
        TextView tvPrediction;
        TextView tvOdd;
        TextView tvDate;
        TextView tvResult;
        TextView tvFinalScore;
    }

}

package com.hfad.vlad.pogodakakiphone.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.vlad.pogodakakiphone.EventBus.TempEvent;
import com.hfad.vlad.pogodakakiphone.R;
import com.hfad.vlad.pogodakakiphone.fiveDayDescriptions.ListDescription;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SecondFragAdapter extends RecyclerView.Adapter<SecondFragAdapter.ViewHolder>{

    private static final String TAG = "SecondFragAdapter";

    private List<ListDescription> listItems;

    private Context context;


    public SecondFragAdapter(Context context, List<ListDescription> listItems) {
        this.listItems = listItems;
        this.context = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dateSecond;
        public ImageView iconSecond;
        public TextView tempSecond;
        public ViewHolder(View itemView) {
            super(itemView);
            dateSecond = itemView.findViewById(R.id.dateSecond);
            iconSecond = itemView.findViewById(R.id.iconSecond);
            tempSecond = itemView.findViewById(R.id.tempSecond);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyc_second_frag,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SecondFragAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        TempEvent event = new TempEvent();

        Date date = new Date(listItems.get(position).getDt()*1000L);
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        String formatter1 = formatter.format(date);
        holder.dateSecond.setText(formatter1);


        Date dateF = new Date(listItems.get(0).getDt()*1000L);
        SimpleDateFormat formatterFirst = new SimpleDateFormat("EE");
        String checkDay = formatterFirst.format(dateF);
        event.setCheckDayEvent(checkDay);

        event.setDescriptionDayEvent(listItems.get(0).getWeather().get(0).getDescription());


        ArrayList<Double> vseTempMax = new ArrayList<>();
        ArrayList<Double> vseTempMin = new ArrayList<>();
        ArrayList<String> vseDni = new ArrayList<>();
        if (position == 0) {
            int posit = 0;
            for (int i = 0; i <= posit; i++) {
                Date dateAll = new Date(listItems.get(posit).getDt()*1000L);

                SimpleDateFormat formatterEE = new SimpleDateFormat("EE");
                String allDay = formatterEE.format(dateAll);
                vseDni.add(allDay);
                vseTempMax.add(listItems.get(posit).getMain().getTempMax());
                vseTempMin.add(listItems.get(posit).getMain().getTempMin());
                posit++;

                if (posit >= 9) {
                    event.setMaxTempEvent(vseTempMax);
                    event.setMinTempEvent(vseTempMin);
                    event.setAllDayEvent(vseDni);
                    EventBus.getDefault().post(event);
                    break;
                }
            }
        }


        String temp = Double.toString(Math.round(listItems.get(position).getMain().getTemp() - 273));
        String gradus = "\u00B0";
        String tempF = temp.substring(0, temp.length() - 2);
        holder.tempSecond.setText(tempF + gradus);


        List<Integer> idIcon = new ArrayList<>();
        idIcon.add(R.drawable.oblachno);
        idIcon.add(R.drawable.iasno);
        idIcon.add(R.drawable.dojd);
        idIcon.add(R.drawable.oblachnonoch);
        idIcon.add(R.drawable.yasnonoch);


        switch (listItems.get(position).getWeather().get(0).getMain()) {
            case "Clouds": if(Integer.valueOf(formatter1) >= 6 && Integer.valueOf(formatter1) < 21) {
                holder.iconSecond.setImageResource(idIcon.get(0));
            } else {
                holder.iconSecond.setImageResource(idIcon.get(3));
            }
            break;
            case "Clear": if (Integer.valueOf(formatter1) >= 6 && Integer.valueOf(formatter1) < 21) {
                holder.iconSecond.setImageResource(idIcon.get(1));
            } else {
                holder.iconSecond.setImageResource(idIcon.get(4));
            }
            break;
            case "Rain": holder.iconSecond.setImageResource(idIcon.get(2));
            break;
            default: holder.iconSecond.setImageResource(idIcon.get(2));
            break;
        }

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

}

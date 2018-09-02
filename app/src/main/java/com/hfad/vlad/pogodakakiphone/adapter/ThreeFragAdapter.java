package com.hfad.vlad.pogodakakiphone.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.vlad.pogodakakiphone.R;
import com.hfad.vlad.pogodakakiphone.fiveDayDescriptions.ListDescription;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ThreeFragAdapter extends RecyclerView.Adapter<ThreeFragAdapter.ViewHolder>{

    private static final String TAG = "ThreeFragAdapter";

    private Context context;
    private List<ListDescription> listItems;

    private List<Integer> countTime = new ArrayList<>();

    private List<Double> tempDayOneMax = new ArrayList<>();
    private List<Double> tempDayTwoMax = new ArrayList<>();
    private List<Double> tempDayThreeMax = new ArrayList<>();
    private List<Double> tempDayFourMax = new ArrayList<>();
    private List<Double> tempDayFiveMax = new ArrayList<>();
    private List<Double> tempDaySixMax = new ArrayList<>();

    private List<Double> tempDayOneMin = new ArrayList<>();
    private List<Double> tempDayTwoMin = new ArrayList<>();
    private List<Double> tempDayThreeMin = new ArrayList<>();
    private List<Double> tempDayFourMin = new ArrayList<>();
    private List<Double> tempDayFiveMin = new ArrayList<>();
    private List<Double> tempDaySixMin = new ArrayList<>();

    private String tempMaxSegOne= "";
    private String tempMaxSegTwo = "";
    private String tempMaxSegThree = "";
    private String tempMaxSegFour = "";
    private String tempMaxSegFive = "";
    private String tempMaxSegSix = "";

    private String tempMinSegOne= "";
    private String tempMinSegTwo = "";
    private String tempMinSegThree = "";
    private String tempMinSegFour = "";
    private String tempMinSegFive = "";
    private String tempMinSegSix = "";


    public ThreeFragAdapter(Context context, List<ListDescription> list) {
        this.context = context;
        this.listItems = list;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyc_three_frag,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Date date = new Date(listItems.get(position).getDt()*1000L);
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        String dayThreeText = formatter.format(date);
        switch (dayThreeText) {
            case "Monday": dayThreeText = "Понедельник";
                break;
            case "Tuesday": dayThreeText = "Вторник";
                break;
            case "Wednesday": dayThreeText = "Среда";
                break;
            case "Thursday": dayThreeText = "Четверг";
                break;
            case "Friday": dayThreeText = "Пятница";
                break;
            case "Saturday": dayThreeText = "Суббота";
                break;
            case "Sunday": dayThreeText = "Воскресенье";
                break;

        }


        holder.dayThree.setText(dayThreeText);



        List<Integer> idIcon = new ArrayList<>();
        idIcon.add(R.drawable.oblachno);
        idIcon.add(R.drawable.iasno);
        idIcon.add(R.drawable.dojd);
        idIcon.add(R.drawable.oblachnonoch);
        idIcon.add(R.drawable.yasnonoch);


        if(position == 0) {
            int countForIcon = 0;

            while (countForIcon < 40) {
                Date dateForIcon = new Date(listItems.get(countForIcon).getDt()*1000L);
                SimpleDateFormat formatterIcon = new SimpleDateFormat("HH");
                String dayThreeIcon = formatterIcon.format(dateForIcon);
                if (dayThreeIcon.equals("12")) {
                    countTime.add(countForIcon);
                }
                countForIcon++;
            }
        }

            int realCountTime = countTime.get(0);


        if (position == 8) {
            switch (listItems.get(countTime.get(0)).getWeather().get(0).getMain()) {
                case "Clouds":
                    holder.iconThree.setImageResource(idIcon.get(0));
                    break;
                case "Clear":
                    holder.iconThree.setImageResource(idIcon.get(1));
                    break;
                case "Rain":
                    holder.iconThree.setImageResource(idIcon.get(2));
                    break;
                default:
                    holder.iconThree.setImageResource(idIcon.get(2));
                    break;
            }
        }
        if (position == 16) {
            switch (listItems.get(countTime.get(1)).getWeather().get(0).getMain()) {
                case "Clouds":
                    holder.iconThree.setImageResource(idIcon.get(0));
                    break;
                case "Clear":
                    holder.iconThree.setImageResource(idIcon.get(1));
                    break;
                case "Rain":
                    holder.iconThree.setImageResource(idIcon.get(2));
                    break;
                default:
                    holder.iconThree.setImageResource(idIcon.get(2));
                    break;
            }
        }
        if (position == 24) {
            switch (listItems.get(countTime.get(2)).getWeather().get(0).getMain()) {
                case "Clouds":
                    holder.iconThree.setImageResource(idIcon.get(0));
                    break;
                case "Clear":
                    holder.iconThree.setImageResource(idIcon.get(1));
                    break;
                case "Rain":
                    holder.iconThree.setImageResource(idIcon.get(2));
                    break;
                default:
                    holder.iconThree.setImageResource(idIcon.get(2));
                    break;
            }
        }
        if (position == 32) {
            switch (listItems.get(countTime.get(3)).getWeather().get(0).getMain()) {
                case "Clouds":
                    holder.iconThree.setImageResource(idIcon.get(0));
                    break;
                case "Clear":
                    holder.iconThree.setImageResource(idIcon.get(1));
                    break;
                case "Rain":
                    holder.iconThree.setImageResource(idIcon.get(2));
                    break;
                default:
                    holder.iconThree.setImageResource(idIcon.get(2));
                    break;
            }
        }
        if (position == 39 && countTime.size() > 4) {
                switch (listItems.get(countTime.get(4)).getWeather().get(0).getMain()) {
                    case "Clouds":
                        holder.iconThree.setImageResource(idIcon.get(0));
                        break;
                    case "Clear":
                        holder.iconThree.setImageResource(idIcon.get(1));
                        break;
                    case "Rain":
                        holder.iconThree.setImageResource(idIcon.get(2));
                        break;
                    default:
                        holder.iconThree.setImageResource(idIcon.get(2));
                        break;
            }
        } else if (position == 39 && countTime.size() <=4 ) {
            switch (listItems.get(39).getWeather().get(0).getMain()) {
                case "Clouds":
                    holder.iconThree.setImageResource(idIcon.get(0));
                    break;
                case "Clear":
                    holder.iconThree.setImageResource(idIcon.get(1));
                    break;
                case "Rain":
                    holder.iconThree.setImageResource(idIcon.get(2));
                    break;
                default:
                    holder.iconThree.setImageResource(idIcon.get(2));
                    break;
            }
        }


        //Raspredelenie temperatur
        if(position == 0) {
            Date dateForTemp1 = new Date(listItems.get(0).getDt()*1000L);
            Date dateForTemp2 = new Date(listItems.get(8).getDt()*1000L);
            Date dateForTemp3 = new Date(listItems.get(16).getDt()*1000L);
            Date dateForTemp4 = new Date(listItems.get(24).getDt()*1000L);
            Date dateForTemp5 = new Date(listItems.get(32).getDt()*1000L);
            Date dateForTemp6 = new Date(listItems.get(39).getDt()*1000L);

            SimpleDateFormat formatterForTemp = new SimpleDateFormat("EE");

            String dayForTemp1 = formatterForTemp.format(dateForTemp1);
            String dayForTemp2 = formatterForTemp.format(dateForTemp2);
            String dayForTemp3 = formatterForTemp.format(dateForTemp3);
            String dayForTemp4 = formatterForTemp.format(dateForTemp4);
            String dayForTemp5 = formatterForTemp.format(dateForTemp5);
            String dayForTemp6 = formatterForTemp.format(dateForTemp6);

            int count = 0;
            while ( count < listItems.size()) {
                Date mDateForTemp = new Date(listItems.get(count).getDt()*1000L);
                SimpleDateFormat formatterForTemp1 = new SimpleDateFormat("EE");
                String mDayForTemp = formatterForTemp1.format(mDateForTemp);
                if(mDayForTemp.equals(dayForTemp1)) {
                    tempDayOneMax.add(listItems.get(count).getMain().getTempMax());
                    tempDayOneMin.add(listItems.get(count).getMain().getTempMin());
                }
                if (mDayForTemp.equals(dayForTemp2)) {
                    tempDayTwoMax.add(listItems.get(count).getMain().getTempMax());
                    tempDayTwoMin.add(listItems.get(count).getMain().getTempMin());
                }
                if (mDayForTemp.equals(dayForTemp3)) {
                    tempDayThreeMax.add(listItems.get(count).getMain().getTempMax());
                    tempDayThreeMin.add(listItems.get(count).getMain().getTempMin());
                }
                if (mDayForTemp.equals(dayForTemp4)) {
                    tempDayFourMax.add(listItems.get(count).getMain().getTempMax());
                    tempDayFourMin.add(listItems.get(count).getMain().getTempMin());
                }
                if (mDayForTemp.equals(dayForTemp5)) {
                    tempDayFiveMax.add(listItems.get(count).getMain().getTempMax());
                    tempDayFiveMin.add(listItems.get(count).getMain().getTempMin());
                }
                if (mDayForTemp.equals(dayForTemp6)) {
                    tempDaySixMax.add(listItems.get(count).getMain().getTempMax());
                    tempDaySixMin.add(listItems.get(count).getMain().getTempMin());
                }

                count++;
            }
            double mTempMaxOne;
            if (tempDayOneMax.size() > 1) {
                mTempMaxOne = Collections.max(tempDayOneMax);
            } else {
                mTempMaxOne = tempDayOneMax.get(0);
            }
            tempMaxSegOne = Double.toString(Math.round(mTempMaxOne - 273)).substring(0, 2);

            double mTempMaxTwo;
            if (tempDayTwoMax.size() > 1) {
                mTempMaxTwo = Collections.max(tempDayTwoMax);
            } else {
                mTempMaxTwo = tempDayTwoMax.get(0);
            }
            tempMaxSegTwo = Double.toString(Math.round(mTempMaxTwo - 273)).substring(0, 2);

            double mTempMaxThree;
            if (tempDayThreeMax.size() > 1) {
                mTempMaxThree = Collections.max(tempDayThreeMax);
            } else {
                mTempMaxThree = tempDayThreeMax.get(0);
            }
            tempMaxSegThree = Double.toString(Math.round(mTempMaxThree - 273)).substring(0, 2);

            double mTempMaxFour;
            if (tempDayFourMax.size() > 1) {
                mTempMaxFour = Collections.max(tempDayFourMax);
            } else {
                mTempMaxFour = tempDayFourMax.get(0);
            }
            tempMaxSegFour = Double.toString(Math.round(mTempMaxFour - 273)).substring(0, 2);


            double mTempMaxFive;
            if (tempDayFiveMax.size() > 1) {
                mTempMaxFive = Collections.max(tempDayFiveMax);
            } else {
                mTempMaxFive = tempDayFiveMax.get(0);
            }
            tempMaxSegFive = Double.toString(Math.round(mTempMaxFive - 273)).substring(0, 2);

            double mTempMaxSix;
            if (tempDaySixMax.size() > 1) {
                mTempMaxSix = Collections.max(tempDaySixMax);
            } else {
                mTempMaxSix = tempDaySixMax.get(0);
            }
            tempMaxSegSix = Double.toString(Math.round(mTempMaxSix - 273)).substring(0, 2);

            double mTempMinOne;
            if (tempDayOneMin.size() > 1) {
                mTempMinOne = Collections.min(tempDayOneMin);
            } else {
                mTempMinOne = tempDayOneMin.get(0);
            }
            tempMinSegOne = Double.toString(Math.round(mTempMinOne - 273)).substring(0, 2);

            double mTempMinTwo;
            if (tempDayTwoMin.size() > 1) {
                mTempMinTwo = Collections.min(tempDayTwoMin);
            } else {
                mTempMinTwo = tempDayTwoMin.get(0);
            }
            tempMinSegTwo = Double.toString(Math.round(mTempMinTwo - 273)).substring(0, 2);

            double mTempMinThree;
            if (tempDayThreeMin.size() > 1) {
                mTempMinThree = Collections.min(tempDayThreeMin);
            } else {
                mTempMinThree = tempDayThreeMin.get(0);
            }
            tempMinSegThree = Double.toString(Math.round(mTempMinThree - 273)).substring(0, 2);

            double mTempMinFour;
            if (tempDayFourMin.size() > 1) {
                mTempMinFour = Collections.min(tempDayFourMin);
            } else {
                mTempMinFour = tempDayFourMin.get(0);
            }
            tempMinSegFour = Double.toString(Math.round(mTempMinFour - 273)).substring(0, 2);


            double mTempMinFive;
            if (tempDayFiveMin.size() > 1) {
                mTempMinFive = Collections.min(tempDayFiveMin);
            } else {
                mTempMinFive = tempDayFiveMin.get(0);
            }
            tempMinSegFive = Double.toString(Math.round(mTempMinFive - 273)).substring(0, 2);

            double mTempMinSix;
            if (tempDaySixMin.size() > 1) {
                mTempMinSix = Collections.min(tempDaySixMin);
            } else {
                mTempMinSix = tempDaySixMin.get(0);
            }
            tempMinSegSix = Double.toString(Math.round(mTempMinSix - 273)).substring(0, 2);



        }


        switch (position) {
//            case 0: holder.maxTempThree.setText(tempMaxSegOne);
//                break;
            case 8: holder.maxTempThree.setText(tempMaxSegTwo);
                break;
            case 16:holder.maxTempThree.setText(tempMaxSegThree);
                break;
            case 24: holder.maxTempThree.setText(tempMaxSegFour);
                break;
            case 32: holder.maxTempThree.setText(tempMaxSegFive);
                break;
            case 39: holder.maxTempThree.setText(tempMaxSegSix);
                break;
            default: holder.maxTempThree.setText("None");
                holder.maxTempThree.setVisibility(View.GONE);
                break;
        }

        switch (position) {
//            case 0: holder.minTempThree.setText(tempMinSegOne);
//                break;
            case 8: holder.minTempThree.setText(tempMinSegTwo);
                break;
            case 16:holder.minTempThree.setText(tempMinSegThree);
                break;
            case 24: holder.minTempThree.setText(tempMinSegFour);
                break;
            case 32: holder.minTempThree.setText(tempMinSegFive);
                break;
            case 39: holder.minTempThree.setText(tempMinSegSix);
                break;
            default: holder.minTempThree.setText("None");
                holder.minTempThree.setVisibility(View.GONE);
                break;
        }



        if (position == 8 || position == 16 || position == 24 || position == 32 || position == 39) {
            holder.dayThree.setVisibility(View.VISIBLE);
            holder.iconThree.setVisibility(View.VISIBLE);
        } else {
            holder.dayThree.setVisibility(View.GONE);
            holder.iconThree.setVisibility(View.GONE);
        }





    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dayThree;
        public ImageView iconThree;
        public TextView maxTempThree;
        public TextView minTempThree;

        public ViewHolder(View itemView) {
            super(itemView);
            dayThree = itemView.findViewById(R.id.dayThree);
            iconThree = itemView.findViewById(R.id.iconThree);
            maxTempThree = itemView.findViewById(R.id.maxTempThree);
            minTempThree = itemView.findViewById(R.id.minTempThree);

        }



    }
}

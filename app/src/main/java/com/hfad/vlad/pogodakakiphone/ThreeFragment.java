package com.hfad.vlad.pogodakakiphone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThreeFragment extends Fragment {


    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        RecyclerView listThree = (RecyclerView) container.findViewById(R.id.list_three);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager();
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

}

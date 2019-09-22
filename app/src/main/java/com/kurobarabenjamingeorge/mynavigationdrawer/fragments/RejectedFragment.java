package com.kurobarabenjamingeorge.mynavigationdrawer.fragments;


import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.kurobarabenjamingeorge.mynavigationdrawer.R;
import com.kurobarabenjamingeorge.mynavigationdrawer.RejectedOnClick;
import com.kurobarabenjamingeorge.mynavigationdrawer.SubmittedOnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RejectedFragment extends Fragment {


    CardView cd1,cd2,cd3,cd4;


    public RejectedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_rejected, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();


        cd1=getActivity().findViewById(R.id.jobrej1);
        cd2=getActivity().findViewById(R.id.jobrej2);
        cd3=getActivity().findViewById(R.id.jobrej3);
        cd4=getActivity().findViewById(R.id.jobrej4);

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(getActivity(), RejectedOnClick.class);
                Bundle extras = new Bundle();
                extras.putString("jobDetail","Job1");
                info.putExtras(extras);
                startActivity(info);
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(getActivity(), RejectedOnClick.class);
                Bundle extras = new Bundle();
                extras.putString("jobDetail","Job3");
                info.putExtras(extras);
                startActivity(info);
            }
        });
        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(getActivity(), RejectedOnClick.class);
                Bundle extras = new Bundle();
                extras.putString("jobDetail","Job4");
                info.putExtras(extras);
                startActivity(info);
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(getActivity(), RejectedOnClick.class);
                Bundle extras = new Bundle();
                extras.putString("jobDetail","Job2");
                info.putExtras(extras);
                startActivity(info);
            }
        });



    }

}

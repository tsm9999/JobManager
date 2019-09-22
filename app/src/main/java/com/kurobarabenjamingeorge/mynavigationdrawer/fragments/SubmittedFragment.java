package com.kurobarabenjamingeorge.mynavigationdrawer.fragments;


import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioButton;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.kurobarabenjamingeorge.mynavigationdrawer.R;
import com.kurobarabenjamingeorge.mynavigationdrawer.SubmittedOnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmittedFragment extends Fragment {

    ProgressBar pbJob1;
    ProgressBar pbJob2;
    ProgressBar pbJob3;
    ProgressBar pbJob4;
    CardView cd1,cd2,cd3,cd4;



    public SubmittedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_submitted, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        pbJob1 = getActivity().findViewById(R.id.progress_jobsub1);
        pbJob1.setProgress(25);
        pbJob2 = getActivity().findViewById(R.id.progress_jobsub2);
        pbJob2.setProgress(35);
        pbJob3 = getActivity().findViewById(R.id.progress_jobsub3);
        pbJob3.setProgress(86);
        pbJob4 = getActivity().findViewById(R.id.progress_jobsub4);
        pbJob4.setProgress(100);


        cd1=getActivity().findViewById(R.id.job1);
        cd2=getActivity().findViewById(R.id.job2);
        cd3=getActivity().findViewById(R.id.job3);
        cd4=getActivity().findViewById(R.id.job4);

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(getActivity(), SubmittedOnClick.class);
                Bundle extras = new Bundle();
                extras.putString("jobDetail","Job1");
                info.putExtras(extras);
                startActivity(info);
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(getActivity(), SubmittedOnClick.class);
                Bundle extras = new Bundle();
                extras.putString("jobDetail","Job3");
                info.putExtras(extras);
                startActivity(info);
            }
        });
        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(getActivity(), SubmittedOnClick.class);
                Bundle extras = new Bundle();
                extras.putString("jobDetail","Job4");
                info.putExtras(extras);
                startActivity(info);
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(getActivity(), SubmittedOnClick.class);
                Bundle extras = new Bundle();
                extras.putString("jobDetail","Job2");
                info.putExtras(extras);
                startActivity(info);
            }
        });



    }

}

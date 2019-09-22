package com.kurobarabenjamingeorge.mynavigationdrawer.fragments;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import com.kurobarabenjamingeorge.mynavigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InProgressFragment extends Fragment {

    ProgressBar pbJob1;
    ProgressBar pbJob2;
    ProgressBar pbJob3;
    ProgressBar pbJob4;
    ProgressBar pbJob5;
    ProgressBar pbJob6;


    public InProgressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_in_progress, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        pbJob1 = getActivity().findViewById(R.id.progress_job1);
        pbJob1.setProgress(25);
        pbJob2 = getActivity().findViewById(R.id.progress_job2);
        pbJob2.setProgress(35);
        pbJob3 = getActivity().findViewById(R.id.progress_job3);
        pbJob3.setProgress(86);
        pbJob4 = getActivity().findViewById(R.id.progress_job4);
        pbJob4.setProgress(100);
//        pbJob5 = getActivity().findViewById(R.id.progress_job5);
//        pbJob5.setProgress(0);
//        pbJob6 = getActivity().findViewById(R.id.progress_job6);
//        pbJob6.setProgress(57);
    }
}

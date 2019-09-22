package com.kurobarabenjamingeorge.mynavigationdrawer.fragments;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.kurobarabenjamingeorge.mynavigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllJobsFragment extends Fragment {


    public AllJobsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_all_jobs, container, false);

    }

}

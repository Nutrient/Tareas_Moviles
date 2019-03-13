package com.iteso.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentElectronics extends Fragment {
    public static FragmentElectronics newInstance(int sectionNumber) {
        FragmentElectronics fragment = new FragmentElectronics();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_electronics, container, false);
        return rootView;
    }
}

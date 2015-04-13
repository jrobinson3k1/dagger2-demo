package com.jasonrobinson.dagger2demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jasonrobinson.dagger2demo.Clock;
import com.jasonrobinson.dagger2demo.DemoApplication;
import com.jasonrobinson.dagger2demo.R;

import java.text.DateFormat;

import javax.inject.Inject;

public class MainFragment extends Fragment {

    private DateFormat mFormat;

    @Inject
    Clock mClock;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mFormat = android.text.format.DateFormat.getLongDateFormat(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((DemoApplication) getActivity().getApplication()).component().inject(this);

        TextView textView = (TextView) view.findViewById(R.id.time_TextView);
        textView.setText(mFormat.format(mClock.getNow().getTime()));
    }
}
package com.ebiii.comeback;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AboutFragment extends Fragment {

    private TextView textView;
    private Typeface typeface;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       rootView = inflater.inflate(R.layout.fragment_about,container,false);
        textView = rootView.findViewById(R.id.txtabout);
        typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/iranm.ttf");
        textView.setTypeface(typeface);
       return rootView;
    }


}

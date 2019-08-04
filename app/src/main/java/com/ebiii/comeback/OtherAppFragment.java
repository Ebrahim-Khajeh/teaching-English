package com.ebiii.comeback;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class OtherAppFragment extends Fragment implements View.OnClickListener {

    private TextView txt1,txt11,txt2,txt22,txt3,
            txt33,txt4,txt44,txt5,txt55,txt6,txt66,txt7,txt77;
    private Typeface typeface,typefaceheader;
    private View rootView;
    private String[] str= {
            "com.developer.typography" ,
                    "com.developer.comeback" ,
                    "devel.martykan.forecastie" ,
                    "div.coders.hub" ,
                    "com.dev.lucidbrowser" ,
                    "com.develope.persiancalendar" ,
                    "ui.ComeBack"
    };;
    private CardView[] cardViews = new CardView[7];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_other_app,container,false);
        typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/iranm.ttf");
        typefaceheader = Typeface.createFromAsset(getActivity().getAssets(),"fonts/iranbold.ttf");
        txt1 = rootView.findViewById(R.id.txt1);
        txt11 = rootView.findViewById(R.id.txt11);
        txt2 = rootView.findViewById(R.id.txt2);
        txt22 = rootView.findViewById(R.id.txt22);
        txt3 = rootView.findViewById(R.id.txt3);
        txt33 = rootView.findViewById(R.id.txt33);
        txt4 = rootView.findViewById(R.id.txt4);
        txt44 = rootView.findViewById(R.id.txt44);
        txt5 = rootView.findViewById(R.id.txt5);
        txt55 = rootView.findViewById(R.id.txt55);
        txt6 = rootView.findViewById(R.id.txt6);
        txt66 = rootView.findViewById(R.id.txt66);
        txt7 = rootView.findViewById(R.id.txt7);
        txt77 = rootView.findViewById(R.id.txt77);
        txt1.setTypeface(typefaceheader);
        txt11.setTypeface(typeface);
        txt2.setTypeface(typefaceheader);
        txt22.setTypeface(typeface);
        txt3.setTypeface(typefaceheader);
        txt33.setTypeface(typeface);
        txt4.setTypeface(typefaceheader);
        txt44.setTypeface(typeface);
        txt5.setTypeface(typefaceheader);
        txt55.setTypeface(typeface);
        txt6.setTypeface(typefaceheader);
        txt66.setTypeface(typeface);
        txt7.setTypeface(typefaceheader);
        txt77.setTypeface(typeface);

        cardViews[0] = rootView.findViewById(R.id.cv1);
        cardViews[1] = rootView.findViewById(R.id.cv2);
        cardViews[2] = rootView.findViewById(R.id.cv3);
        cardViews[3] = rootView.findViewById(R.id.cv4);
        cardViews[4] = rootView.findViewById(R.id.cv5);
        cardViews[5] = rootView.findViewById(R.id.cv6);
        cardViews[6] = rootView.findViewById(R.id.cv7);

        cardViews[0].setOnClickListener(this);
        cardViews[1].setOnClickListener(this);
        cardViews[2].setOnClickListener(this);
        cardViews[3].setOnClickListener(this);
        cardViews[4].setOnClickListener(this);
        cardViews[5].setOnClickListener(this);
        cardViews[6].setOnClickListener(this);


        return rootView;
     }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cv1:
                feedback(str[0]);break;
            case R.id.cv2:
                feedback(str[1]);break;
            case R.id.cv3:
                feedback(str[2]);break;
            case R.id.cv4:
                feedback(str[3]);break;
            case R.id.cv5:
                feedback(str[4]);break;
            case R.id.cv6:
                feedback(str[5]);break;
            case R.id.cv7:
                feedback(str[6]);break;
        }
    }

    private void feedback(String packageName){
       try {
           Intent intent = new Intent(Intent.ACTION_VIEW);
           intent.setData(Uri.parse("bazaar://details?id=" + packageName));
           intent.setPackage("com.farsitel.bazaar");
           startActivity(intent);
       }catch (RuntimeException ex){
           Toast.makeText(getActivity(), "لطفا برنامه بازار را نصب کنید", Toast.LENGTH_SHORT).show();
       }
    }
}

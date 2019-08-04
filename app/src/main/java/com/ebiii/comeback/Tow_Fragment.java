package com.ebiii.comeback;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tow_Fragment extends Fragment {

    private View rootView;

    private CardView  btn1,btn2 , btn3 , btn4;
    private Typeface typeface;
    private TextView textView1 , textView2 , textView3 , textView4 , textView5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tow_,container,false);
        btn1 = rootView.findViewById(R.id.btn1);
        btn2 = rootView.findViewById(R.id.btn2);
        btn3 = rootView.findViewById(R.id.btn3);
        btn4 = rootView.findViewById(R.id.btn4);
        MainActivity._ID = 0;
        textView1 = rootView.findViewById(R.id.txt_adapter);
        textView2 = rootView.findViewById(R.id.txt_adapter2);
        textView3 = rootView.findViewById(R.id.txt_adapter3);
        textView4 = rootView.findViewById(R.id.txt_adapter4);
        textView5 = rootView.findViewById(R.id.tp);
        typeface = Typeface.createFromAsset(getActivity().
                getAssets(),"fonts/iranbold.ttf");
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        textView3.setTypeface(typeface);
        textView4.setTypeface(typeface);
        textView5.setTypeface(typeface);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity._ID = 11;
                ListDroosFragment listDroosFragment =
                        new ListDroosFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.frm,listDroosFragment)
                        .commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity._ID = 22;
                Lesson_part_1 lesson_part_1 =
                        new Lesson_part_1();
                getFragmentManager().beginTransaction()
                        .replace(R.id.frm,lesson_part_1)
                        .commit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity._ID = 33;
                Lesson_part_2 lesson_part_2 =
                        new Lesson_part_2();
                getFragmentManager().beginTransaction()
                        .replace(R.id.frm,lesson_part_2)
                        .commit();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity._ID = 44;
                Lesson_psrt_3 lesson_part_3 =
                        new Lesson_psrt_3();
                getFragmentManager().beginTransaction()
                        .replace(R.id.frm,lesson_part_3)
                        .commit();
            }
        });

        return rootView;
    }


}

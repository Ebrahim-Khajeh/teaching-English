package com.ebiii.comeback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListDroosFragment extends Fragment {

    private ListView listView;
    private View rootView;
    private List<ListDroos> lst;
    private ListDroosArrayAdapter adapter;
    private String[] str = {
            "THE KINDERGARTEN MAN" ,
                    "THE FUNNY FARMHAND" ,
                    "A STORY ABOUT NEWTON" ,
                    "THE SCHOOL BUS" ,
                    "LEARN A FOREIGN LANGUAGE" ,
                    "A BOY WHO MADE STEAM WORK" ,
                    "HIGHWAYS IN THE SKY" ,
                    "EAT, CLOTHES, EAT!" ,
                    "THE HOLY PROPHET" ,
                    "WASHOE AND THE PUZZLES" ,
                    "THE OTHER SIDE OF THE MOON" ,
                    "HOLLAND'S TOY TOWN" ,
                    "CHARLES DICKENS AND THE LITTLE CHILDREN" ,
                    "THE LITTLE OLD MAN WHO COULD NOT READ" ,
                    "HIC, HIC, HIC!" ,
                    "HOW ARE YOU?"
    };
    private String[] namehint = {
     "مهدکودک" ,
             "کشاورز" ,
             "داستانی درباره نیوتون" ,
             "اتوبوس مدرسه" ,
             "یادگیری زبانی دیگر" ,
             "بخار آب" ,
             "بزرگراه" ,
             "بخورید لباس ها" ,
             "پیامبر اعظم" ,
             "پازل" ,
             "طرف دیگر ماه" ,
             "شهر اسباب بازی" ,
             "چارلز دیکنز" ,
             "پیرمردی که نمیتواند بخواند" ,
             "سک سکه !" ,
             "در چه حالی"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list_droos,container,false);
        listView = rootView.findViewById(R.id.listViewtDroos);
        MainActivity._ID = 20;
        lst = new ArrayList<>();



        for (int i = 0 ; i<str.length ; i++) {
            lst.add(new ListDroos(str[i], R.drawable.bookmark,namehint[i]));
        }

        adapter = new ListDroosArrayAdapter(getActivity(),lst);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WebViewFragment webViewFragment = WebViewFragment.newInstance(i,1);
                getFragmentManager().beginTransaction()
                        .replace(R.id.frm,webViewFragment)
                        .commit();
            }
        });
        return rootView;
     }

}

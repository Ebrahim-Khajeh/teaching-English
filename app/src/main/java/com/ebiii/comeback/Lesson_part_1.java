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


public class Lesson_part_1 extends Fragment {

    private View rootView;
    private List<ListLesson> lst;
    private ListView listView;
    private String[] str = {
            "Lesson 1" ,
                    "Lesson 2" ,
                    "Lesson 3" ,
                    "Lesson 4" ,
                    "Lesson 5" ,
                    "Lesson 6" ,
                    "Lesson 7" ,
                    "Lesson 8" ,
                    "Lesson 9" ,
                    "Lesson 10" ,
                    "Lesson 11" ,
                    "Lesson 12" ,
                    "Lesson 13" ,
                    "Lesson 14" ,
                    "Lesson 15" ,
                    "Lesson 16" ,
                    "Lesson 17" ,
                    "Lesson 18" ,
                    "Lesson 19" ,
                    "Lesson 20" ,
                    "Lesson 21" ,
                    "Lesson 22" ,
                    "Lesson 23" ,
                    "Lesson 24" ,
                    "Lesson 25" ,
                    "Lesson 26" ,
                    "Lesson 27"

    };
    private ListLessonArrayAdapter listLessonArrayAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lesson_part_1,container,false);
        listView = rootView.findViewById(R.id.listviewlesson1);
        lst = new ArrayList<>();
        MainActivity._ID = 20;

        for(int i = 0; i < str.length ; i++){
            lst.add(new ListLesson(str[i],R.drawable.readbook));
        }
        listLessonArrayAdapter = new
                ListLessonArrayAdapter(getActivity(),lst);
        listView.setAdapter(listLessonArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WebViewFragment webViewFragment = WebViewFragment.newInstance(i,2);
                getFragmentManager().beginTransaction()
                        .replace(R.id.frm,webViewFragment)
                        .commit();
            }
        });
        return rootView;

     }


}

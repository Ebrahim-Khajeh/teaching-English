package com.ebiii.comeback;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by M.R.S.L.Y on 5/10/2018.
 */

public class ListLessonArrayAdapter extends ArrayAdapter{

    private LayoutInflater layoutInflater;
    private View rootView;
    private List<ListLesson> lst;
    private Typeface typeface;
    public ListLessonArrayAdapter(@NonNull Context context, @NonNull List<ListLesson> objects) {
        super(context, R.layout.list_lesson, objects);
        lst = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rootView = layoutInflater.inflate(R.layout.list_lesson,parent,false);
        TextView textView = rootView.findViewById(R.id.txt_lesson);
        typeface = Typeface.createFromAsset(getContext().getAssets(),"fonts/iranbold.ttf");
        ImageView imageView = rootView.findViewById(R.id.im);
        imageView.setImageResource(lst.get(position).getId());
        textView.setText(lst.get(position).getTitle());
        textView.setTypeface(typeface);
        return rootView;
    }
}

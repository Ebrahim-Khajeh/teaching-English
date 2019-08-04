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
 * Created by M.R.S.L.Y on 5/8/2018.
 */

public class CostumAdapter extends ArrayAdapter {

    private List<Main_Form_Class> lst;
    private LayoutInflater layoutInflater;
    private View rootView;
    private String name;
    private Typeface typeface;

    public CostumAdapter(@NonNull Context context,
                         @NonNull List<Main_Form_Class> lst) {
        super(context, R.layout.costum_adapter, lst);
        this.lst = lst;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        layoutInflater = LayoutInflater.from(getContext());
        rootView = layoutInflater.inflate(R.layout.costum_adapter,parent,false);
        final TextView textView = rootView.findViewById(R.id.txt_adapter);
        ImageView imageView = rootView.findViewById(R.id.img_dapter);
        typeface = Typeface.createFromAsset(getContext().getAssets(),"fonts/iranbold.ttf");
        textView.setText(lst.get(position).getName());
        textView.setTypeface(typeface);
        imageView.setImageResource(lst.get(position).getId());

        return rootView;
    }
}

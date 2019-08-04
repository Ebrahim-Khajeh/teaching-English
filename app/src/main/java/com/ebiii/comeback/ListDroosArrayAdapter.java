package com.ebiii.comeback;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by M.R.S.L.Y on 5/9/2018.
 */
public class ListDroosArrayAdapter extends ArrayAdapter {

    private List<ListDroos> lst;
    private LayoutInflater layoutInflater;
    private View rootView;
    private Typeface typeface,typeface2;
    public ListDroosArrayAdapter(@NonNull Context context,
                                 @NonNull List<ListDroos> objects) {
        super(context, R.layout.list_darsha, objects);
        lst = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        layoutInflater = LayoutInflater.from(getContext());
        rootView = layoutInflater.inflate(R.layout.list_darsha,parent,false);
        TextView textView = rootView.findViewById(R.id.txt_doros);
        typeface = Typeface.createFromAsset(getContext().getAssets(),"fonts/iranm.ttf");
        typeface2 = Typeface.createFromAsset(getContext().getAssets(),"fonts/iranm.ttf");
//        ImageView imageView = rootView.findViewById(R.id.imageViewlistdroos);
//        imageView.setImageResource(lst.get(position).getId());
        TextView txthint = rootView.findViewById(R.id.txt_doros_hint);
        txthint.setText("خلاصه : "+lst.get(position).getNamehint());
        textView.setText(lst.get(position).getName());
        txthint.setTypeface(typeface);
        textView.setTypeface(typeface2);
        return rootView;
    }
}

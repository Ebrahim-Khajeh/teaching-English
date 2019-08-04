package com.ebiii.comeback;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.R.S.L.Y on 5/8/2018.
 */

public class Fragment_Amozesh extends Fragment {

    private View rootView;
    private List<Main_Form_Class> lst;
    private GridView listView;
    private CostumAdapter costumAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.amozesh_fragment,container,false);
        listView = (GridView) rootView.findViewById(R.id.listview_fragment_amozesh);
        lst = new ArrayList<>();
        lst.add(new Main_Form_Class("داستان",R.drawable.book));
        lst.add(new Main_Form_Class("دیکشنری",R.drawable.dic));
        lst.add(new Main_Form_Class("بهترین ها",R.drawable.otherapp));
        lst.add(new Main_Form_Class("ارتباط با ما",R.drawable.aboutus));
        costumAdapter = new CostumAdapter(getContext(),lst);

        listView.setAdapter(costumAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               switch (i){
                   case 0:
                       Tow_Fragment tow_fragment = new Tow_Fragment();
                       getFragmentManager().beginTransaction()
                               .replace(R.id.frm,tow_fragment)
                               .commit();break;
                   case 1:
                       DictionaryFragment dictionaryFragment =
                               new DictionaryFragment();
                       getFragmentManager().beginTransaction()
                               .replace(R.id.frm,dictionaryFragment)
                               .commit();
                       break;
                   case 2:
//                       OtherAppFragment otherAppFragment = new OtherAppFragment();
//                       getFragmentManager().beginTransaction()
//                               .replace(R.id.frm,otherAppFragment)
//                               .commit();
                       try {
                           Intent intent = new Intent(Intent.ACTION_VIEW);
                           intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + "nc_521"));
                           intent.setPackage("com.farsitel.bazaar");
                           startActivity(intent);
                       }catch (RuntimeException e){
                           Toast t = Toast.makeText(view.getContext(), "برنامه بازار بر روی گوشی شما نصب نیست", Toast.LENGTH_SHORT);
                           t.getView().setBackgroundColor(getResources()
                                   .getColor(R.color.colorAccent));
                           t.show();
                       }
                       break;
                   case 3:
                       AboutFragment aboutFragment = new
                               AboutFragment();
                       getFragmentManager().beginTransaction()
                               .replace(R.id.frm,aboutFragment)
                               .commit();break;

               }
            }
        });
        return rootView;
    }

}


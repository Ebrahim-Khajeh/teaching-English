package com.ebiii.comeback;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class DictionaryFragment extends Fragment {

    private DatabaseAccess databaseAccess;
    private View rootView;
    private TextView txtResults;
    private Button btnShowResults,btnClear;
    private EditText edtSearch;
    private RadioGroup radioGroup;
    private Typeface typeface;
    private RadioButton r1,r2;
    private  List<String> lst_en;
    private  List<String> lst_en2;
    private String name;
    private int counter = -1;
    private static int jump = 1;
    private LinearLayout l;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_dictionary,container,false);
        Fullvariable fullvariable = new Fullvariable();
        fullvariable.execute();

        typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/iranm.ttf");
        l = rootView.findViewById(R.id.li1);
        r1 = rootView.findViewById(R.id.etp);
        r2 = rootView.findViewById(R.id.pte);

        btnShowResults = rootView.findViewById(R.id.btnSearch);
        edtSearch = rootView.findViewById(R.id.editTextSearch);
        txtResults = rootView.findViewById(R.id.txtResults);
        radioGroup = rootView.findViewById(R.id.group);
        btnClear = rootView.findViewById(R.id.clear);
        //  تنظیمات ظاهر اولیه دیکشنری
        edtSearch.setGravity(Gravity.LEFT);
        txtResults.setGravity(Gravity.RIGHT);
        edtSearch.setTypeface(typeface);
        txtResults.setTypeface(typeface);
        btnShowResults.setTypeface(typeface);
        r1.setTypeface(typeface);
        r2.setTypeface(typeface);

//        edtSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                edtSearch.setHint("");
//
//            }
//        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.etp:
                        edtSearch.setGravity(Gravity.LEFT);
                        txtResults.setGravity(Gravity.RIGHT);
                        txtResults.setText("");
                        edtSearch.setText("");
                        jump = 1;
                        break;
                    case R.id.pte:
                        edtSearch.setGravity(Gravity.RIGHT);
                        txtResults.setGravity(Gravity.LEFT);
                        txtResults.setText("");
                        edtSearch.setText("");
                        jump = 2;
                       break;

                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResults.setText("");
                edtSearch.setText("");
            }
        });
        btnShowResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Locale.getDefault().getLanguage().contentEquals("فارسی")){
                        edtSearch.setError("لطفا کلمه خود را به زبان انگلیسی تایپ کنید");
                }else if (edtSearch.getText().toString().trim().contentEquals("")) {
                   edtSearch.setError("لطفا کلمه خود را وارد کنید");
                }else{
                    SearchEnglishToPersian searchEnglishToPersian =
                        new SearchEnglishToPersian(getContext());
                     searchEnglishToPersian.execute();
            }
               }
        });


        return rootView;
     }

     private class Fullvariable extends AsyncTask<Void,Void,Void>{

         @Override
         protected Void doInBackground(Void... voids) {
             databaseAccess = DatabaseAccess.getInstance(getActivity());
             databaseAccess.open();
             lst_en= databaseAccess.getQuotes("tbl_words","word");
             lst_en2= databaseAccess.getQuotes("tbl_words","translate");
             return null;
         }

         @Override
         protected void onPostExecute(Void aVoid) {
             databaseAccess.close();
         }
     }

     private class SearchEnglishToPersian extends AsyncTask<Void,Void,Void>{

        private ProgressDialog progressDialog;
        public SearchEnglishToPersian(Context context){
            progressDialog = new ProgressDialog(context);

        }

         @Override
         protected void onPreExecute() {
             progressDialog.setMessage("در حال جستجو ...");
             progressDialog.setCancelable(false);
             progressDialog.show();
         }

         @Override
         protected Void doInBackground(Void... voids) {
             name = edtSearch.getText().toString().trim();
               for (int i = 0 ; i < lst_en.size() ; i++){
                 if(name.equalsIgnoreCase(lst_en.get(i).toString().trim())){
                        counter = i;
                 }
             }

             return null;
         }

         @Override
         protected void onPostExecute(Void aVoid) {
             if (progressDialog.isShowing()){
                 progressDialog.dismiss();
             }
             if(counter > -1){
                 txtResults.setText(lst_en2.get(counter).toString());
                 counter = -1;
             }else{
                 txtResults.setText("نتیجه یافت نشد");
             }
         }
     }


}

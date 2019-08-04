package com.ebiii.comeback;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class WebViewFragment extends Fragment {

    private View rootView;
    public WebView webView;
    private String[] str;
    private int counter;
    private static int cp;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private int count = 0;

    private String[] filepath = {
            "file:///android_asset/html/index_0.htm" ,
                    "file:///android_asset/html/index_1.htm" ,
                    "file:///android_asset/html/index_2.htm" ,
                    "file:///android_asset/html/index_3.htm" ,
                    "file:///android_asset/html/index_4.htm" ,
                    "file:///android_asset/html/index_5.htm" ,
                    "file:///android_asset/html/index_6.htm" ,
                    "file:///android_asset/html/index_8.htm" ,
                    "file:///android_asset/html/index_9.htm" ,
                    "file:///android_asset/html/index_10.htm" ,
                    "file:///android_asset/html/index_11.htm" ,
                    "file:///android_asset/html/index_12.htm" ,
                    "file:///android_asset/html/index_13.htm" ,
                    "file:///android_asset/html/index_14.htm" ,
                    "file:///android_asset/html/index_15.htm" ,
                    "file:///android_asset/html/index_16.htm"

    };

    private  String[] filepath_l = {
            "file:///android_asset/html/l1.htm" ,
                    "file:///android_asset/html/l2.htm" ,
                    "file:///android_asset/html/l3.htm" ,
                    "file:///android_asset/html/l4.htm" ,
                    "file:///android_asset/html/l5.htm" ,
                    "file:///android_asset/html/l6.htm" ,
                    "file:///android_asset/html/l7.htm" ,
                    "file:///android_asset/html/l8.htm" ,
                    "file:///android_asset/html/l9.htm" ,
                    "file:///android_asset/html/l10.htm" ,
                    "file:///android_asset/html/l11.htm" ,
                    "file:///android_asset/html/l12.htm" ,
                    "file:///android_asset/html/l13.htm" ,
                    "file:///android_asset/html/l14.htm" ,
                    "file:///android_asset/html/l15.htm" ,
                    "file:///android_asset/html/l16.htm" ,
                    "file:///android_asset/html/l17.htm" ,
                    "file:///android_asset/html/l18.htm" ,
                    "file:///android_asset/html/l19.htm" ,
                    "file:///android_asset/html/l20.htm" ,
                    "file:///android_asset/html/l21.htm" ,
                    "file:///android_asset/html/l22.htm" ,
                    "file:///android_asset/html/l23.htm" ,
                    "file:///android_asset/html/l24.htm" ,
                    "file:///android_asset/html/l25.htm" ,
                    "file:///android_asset/html/l26.htm" ,
                    "file:///android_asset/html/l27.htm"
    };
    private String[] filepath_ll = {
            "file:///android_asset/html/ll1.htm" ,
                    "file:///android_asset/html/ll2.htm" ,
                    "file:///android_asset/html/ll3.htm" ,
                    "file:///android_asset/html/ll4.htm" ,
                    "file:///android_asset/html/ll5.htm" ,
                    "file:///android_asset/html/ll6.htm" ,
                    "file:///android_asset/html/ll7.htm" ,
                    "file:///android_asset/html/ll8.htm" ,
                    "file:///android_asset/html/ll9.htm" ,
                    "file:///android_asset/html/ll10.htm" ,
                    "file:///android_asset/html/ll11.htm" ,
                    "file:///android_asset/html/ll12.htm" ,
                    "file:///android_asset/html/ll13.htm" ,
                    "file:///android_asset/html/ll14.htm" ,
                    "file:///android_asset/html/ll15.htm" ,
                    "file:///android_asset/html/ll16.htm" ,
                    "file:///android_asset/html/ll17.htm" ,
                    "file:///android_asset/html/ll18.htm" ,
                    "file:///android_asset/html/ll19.htm" ,
                    "file:///android_asset/html/ll20.htm" ,
                    "file:///android_asset/html/ll21.htm" ,
                    "file:///android_asset/html/ll22.htm" ,
                    "file:///android_asset/html/ll23.htm" ,
                    "file:///android_asset/html/ll24.htm" ,
                    "file:///android_asset/html/ll25.htm" ,
                    "file:///android_asset/html/ll26.htm" ,
                    "file:///android_asset/html/ll27.htm"
    };

    private String[] filepath_kl = {
            "file:///android_asset/html/kl1.htm" ,
                    "file:///android_asset/html/kl1.htm" ,
                    "file:///android_asset/html/kl2.htm" ,
                    "file:///android_asset/html/kl3.htm" ,
                    "file:///android_asset/html/kl4.htm" ,
                    "file:///android_asset/html/kl5.htm" ,
                    "file:///android_asset/html/kl6.htm" ,
                    "file:///android_asset/html/kl7.htm" ,
                    "file:///android_asset/html/kl8.htm" ,
                    "file:///android_asset/html/kl9.htm" ,
                    "file:///android_asset/html/kl10.htm" ,
                    "file:///android_asset/html/kl11.htm" ,
                    "file:///android_asset/html/kl12.htm" ,
                    "file:///android_asset/html/kl13.htm" ,
                    "file:///android_asset/html/kl14.htm" ,
                    "file:///android_asset/html/kl15.htm" ,
                    "file:///android_asset/html/kl16.htm" ,
                    "file:///android_asset/html/kl17.htm" ,
                    "file:///android_asset/html/kl18.htm" ,
                    "file:///android_asset/html/kl19.htm",
                    "file:///android_asset/html/kl20.htm" ,
                    "file:///android_asset/html/kl21.htm" ,
                    "file:///android_asset/html/kl22.htm" ,
                    "file:///android_asset/html/kl23.htm" ,
                    "file:///android_asset/html/kl24.htm" ,
                    "file:///android_asset/html/kl25.htm" ,
                    "file:///android_asset/html/kl26.htm" ,
                    "file:///android_asset/html/kl27.htm" ,
                    "file:///android_asset/html/kl28.htm" ,
                    "file:///android_asset/html/kl29.htm" ,
                    "file:///android_asset/html/kl30.htm"
    };

    public static WebViewFragment newInstance(int v,int p) {
        MainActivity._ID = p;
        cp = p;
        Bundle args = new Bundle();
        args.putInt("count",v);
        WebViewFragment fragment = new WebViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = getArguments().getInt("count");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_web_view,container,false);

        preferences = getContext().getSharedPreferences("me",Context.MODE_PRIVATE);
        count = preferences.getInt("id",1);
        if(count == 0){
           editor = preferences.edit();
           editor.putInt("id",1);
           editor.commit();
       }

       if(preferences.getInt("id",1) == 1){
           AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
           builder.setMessage("برای مشاهده معنای کلمات ، کلمه مورد نظر را فقط لمس کنید")
                   .setTitle("اعلان")
                   .setCancelable(false)
                   .setPositiveButton("گرفتم", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           editor = preferences.edit();
                           editor.putInt("id",10);
                           editor.commit();
                           dialogInterface.dismiss();
                       }
                   }).show();

       }

        webView = rootView.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        switch (cp){
            case 1:
                str = filepath_kl;break;
            case 2:
                str =filepath_l;break;
            case 3:
                str = filepath_ll;break;
            case 4:
                str = filepath_kl;break;

        }
        ShowTextIntoWebView showTextIntoWebView =
                new ShowTextIntoWebView(getActivity());
        showTextIntoWebView.execute();
        return rootView;
   }

     class ShowTextIntoWebView extends AsyncTask<Void,Void,Void>{
        private ProgressDialog progressDialog;

          public ShowTextIntoWebView(Context context){
              progressDialog = new ProgressDialog(context);

          }

         @Override
         protected void onPreExecute() {
             progressDialog.setMessage("لطفا چند لحظه صبر کنید");
             progressDialog.setCancelable(false);
             progressDialog.show();
         }

         @Override
         protected Void doInBackground(Void... voids) {

             return null;
         }

         @Override
         protected void onPostExecute(Void aVoid) {
              new Handler().postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      if(progressDialog.isShowing()){
                          progressDialog.dismiss();}
                  }
              },2000);

                 webView.loadUrl(str[counter]);

         }
     }


}

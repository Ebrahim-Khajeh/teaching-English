package com.ebiii.comeback;


import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class String_Roydad extends SQLiteAssetHelper{

    private final static String DB_NAME = "PcDic.db3";
    private final static int VERSION = 1;



    public String_Roydad(Context context) {
        super(context, DB_NAME, null, VERSION);

    }


}

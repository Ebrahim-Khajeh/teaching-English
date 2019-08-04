package com.ebiii.comeback;

import android.app.Activity;
import android.widget.FrameLayout;

/**
 * Created by M.R.S.L.Y on 5/8/2018.
 */

public class ContentMain {
    private Activity activity;
    private FrameLayout frameLayout;

    public ContentMain(Activity activity){
        this.activity = activity;
        init();
    }

    private void init() {
        frameLayout = (FrameLayout)activity.findViewById(R.id.frm);
    }

    public FrameLayout getFrameLayout() {
        return frameLayout;
    }
}

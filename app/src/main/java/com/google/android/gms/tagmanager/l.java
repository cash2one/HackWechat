package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.af.1;
import java.util.HashMap;
import java.util.Map;

public class l {
    private static String bbH;
    static Map<String, String> bbI = new HashMap();

    public static void be(String str) {
        synchronized (l.class) {
            bbH = str;
        }
    }

    public static void i(Context context, String str) {
        String queryParameter = Uri.parse("http://hostname/?" + str).getQueryParameter("conv");
        if (queryParameter != null && queryParameter.length() > 0) {
            bbI.put(queryParameter, str);
            Editor edit = context.getSharedPreferences("gtm_click_referrers", 0).edit();
            edit.putString(queryParameter, str);
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                new Thread(new 1(edit)).start();
            }
        }
    }
}

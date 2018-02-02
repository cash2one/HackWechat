package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;

public final class h {
    public static boolean zMA = true;
    private static long zMB = -1;
    public static int zMC = a.zME;
    private static int zMD = a.zME;

    private static NetworkInfo getNetworkInfo() {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) d.ssG.getSystemService("connectivity");
        } catch (Exception e) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            c.m("getSystemService(Context.CONNECTIVITY_SERVICE) null", new Object[0]);
            return null;
        }
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            c.m("getActiveNetworkInfo exception:", new Object[]{th});
            activeNetworkInfo = null;
        }
        return activeNetworkInfo;
    }

    public static boolean isNetworkConnected() {
        try {
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo == null) {
                return false;
            }
            return networkInfo.isConnected();
        } catch (Exception e) {
            return true;
        }
    }
}

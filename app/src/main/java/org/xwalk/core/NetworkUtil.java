package org.xwalk.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {
    private static final int NON_NETWORK = 0;
    private static final int OTHER = 4;
    private static final int WIFI = 1;
    private static final int _3G = 2;
    private static final int _4G = 3;

    public static int getCurrentNetWorkStatus(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        if (!activeNetworkInfo.isConnected()) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        if (activeNetworkInfo.getSubtype() >= 13) {
            return 3;
        }
        if (activeNetworkInfo.getSubtype() < 5 || activeNetworkInfo.getSubtype() >= 13) {
            return 4;
        }
        return 2;
    }

    public static boolean isNetworkAvailable() {
        if (Integer.valueOf(getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext())).intValue() != 0) {
            return true;
        }
        XWalkInitializer.addXWalkInitializeLog("no network");
        return false;
    }

    public static boolean isWifiAvailable() {
        switch (Integer.valueOf(getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext())).intValue()) {
            case 1:
                return true;
            default:
                return false;
        }
    }
}

package com.tinkerboots.sdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class a {
    private static ConnectivityManager Auu = null;

    public static boolean isConnected(Context context) {
        if (Auu == null) {
            Auu = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (Auu == null) {
            return false;
        }
        boolean z;
        NetworkInfo activeNetworkInfo = Auu.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            try {
                if (activeNetworkInfo.isConnected()) {
                    z = true;
                    return z;
                }
            } catch (Exception e) {
                return false;
            }
        }
        z = false;
        return z;
    }

    public static boolean isWifi(Context context) {
        if (Auu == null) {
            Auu = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (Auu == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = Auu.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }
}

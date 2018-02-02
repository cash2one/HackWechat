package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

public final class ac {
    private static Context context = null;
    private static String ffw = "com.tencent.mm";
    private static volatile Resources mResources = null;
    private static String processName = ffw;
    private static String xfq = "com.tencent.mm";
    private static String xfr = "com.tencent.mm.ui.LauncherUI";
    private static boolean xfs = false;
    public static boolean xft = false;
    private static ActivityManager xfu = null;

    public static void lA(boolean z) {
        xfs = z;
    }

    public static boolean cfp() {
        return xfs;
    }

    public static String cfq() {
        return xfr;
    }

    public static void setContext(Context context) {
        context = context;
        ffw = context.getPackageName();
        x.d("MicroMsg.MMApplicationContext", "setup application context for package: " + ffw);
    }

    public static Context getContext() {
        return context;
    }

    public static String getPackageName() {
        return ffw;
    }

    public static String cfr() {
        return xfq;
    }

    public static String cfs() {
        return ffw + "_preferences";
    }

    public static SharedPreferences cft() {
        if (context != null) {
            return context.getSharedPreferences(cfs(), 0);
        }
        return null;
    }

    public static SharedPreferences cfu() {
        if (context != null) {
            return context.getSharedPreferences(ffw + "_preferences_tools", 0);
        }
        return null;
    }

    public static String cfv() {
        return ffw + "_tmp_preferences";
    }

    public static String Br() {
        return processName;
    }

    public static void Va(String str) {
        processName = str;
    }

    public static boolean cfw() {
        Object obj = processName;
        if (obj == null || obj.length() == 0) {
            obj = ffw;
        }
        return ffw.equals(obj);
    }

    public static boolean cfx() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ffw;
        }
        return "com.tencent.mm:push".equalsIgnoreCase(str);
    }

    public static boolean cfy() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ffw;
        }
        return "com.tencent.mm:tools".equalsIgnoreCase(str);
    }

    public static boolean cfz() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ffw;
        }
        return "com.tencent.mm:exdevice".equalsIgnoreCase(str);
    }

    public static boolean cfA() {
        return Vb(ffw);
    }

    private static boolean Vb(String str) {
        if (context == null || ffw == null) {
            return false;
        }
        if (xfu == null) {
            xfu = (ActivityManager) context.getSystemService("activity");
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : xfu.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + e.toString());
            return false;
        } catch (Error e2) {
            x.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + e2.toString());
            return false;
        }
    }

    public static Resources getResources() {
        return mResources;
    }

    public static void a(Resources resources) {
        mResources = resources;
    }
}

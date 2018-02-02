package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.smtt.sdk.WebView;

public final class p {
    private static String AaU = null;
    private static String AaV = "GA";
    private static String AaW = "GE";
    private static String AaX = "9422";
    private static String AaY = "0";
    private static String AaZ = "";
    private static boolean Aba = false;
    private static boolean Abb = false;
    private static boolean Abc = false;

    private static String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        String str8 = "";
        String str9 = "";
        String str10 = "PHONE";
        StringBuilder stringBuilder = new StringBuilder();
        String str11 = hX(context) + "*" + hY(context);
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            str8 = applicationInfo.packageName;
            if (TextUtils.isEmpty(str7)) {
                str7 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            str7 = str9;
        }
        String str12 = str8.equals("com.tencent.mm") ? "WX" : str8.equals("com.tencent.mobileqq") ? "QQ" : str8.equals("com.qzone") ? "QZ" : str8.equals("com.tencent.mtt") ? "QB" : "TRD";
        if ("QB".equals(str12)) {
            if (z) {
                str9 = "PAD";
            }
            str9 = str10;
        } else {
            boolean z2;
            if (Abb) {
                z2 = Abc;
            } else {
                int i;
                int min = Math.min(hX(context), hY(context)) * JsApiSetBackgroundAudioState.CTRL_INDEX;
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Display defaultDisplay = windowManager.getDefaultDisplay();
                if (defaultDisplay != null) {
                    defaultDisplay.getMetrics(displayMetrics);
                    i = displayMetrics.densityDpi;
                } else {
                    i = JsApiSetBackgroundAudioState.CTRL_INDEX;
                }
                Abc = min / i >= 700;
                Abb = true;
                z2 = Abc;
            }
            if (z2) {
                str9 = "PAD";
            }
            str9 = str10;
        }
        stringBuilder.append("QV=3");
        b(stringBuilder, "PL", "ADR");
        b(stringBuilder, "PR", str12);
        b(stringBuilder, "PP", str8);
        b(stringBuilder, "PPVN", str7);
        if (!TextUtils.isEmpty(str)) {
            b(stringBuilder, "TBSVC", str);
        }
        b(stringBuilder, "CO", "SYS");
        if (!TextUtils.isEmpty(str2)) {
            b(stringBuilder, "COVC", str2);
        }
        b(stringBuilder, "PB", str4);
        b(stringBuilder, "VE", str3);
        b(stringBuilder, "DE", str9);
        str9 = "CHID";
        if (TextUtils.isEmpty(str6)) {
            str6 = "0";
        }
        b(stringBuilder, str9, str6);
        b(stringBuilder, "LCID", str5);
        str8 = " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
        try {
            Object str13 = new String(str8.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e2) {
            str9 = str8;
        }
        if (!TextUtils.isEmpty(str13)) {
            b(stringBuilder, "MO", str13);
        }
        b(stringBuilder, "RL", str11);
        str8 = VERSION.RELEASE;
        try {
            str13 = new String(str8.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e3) {
            str9 = str8;
        }
        if (!TextUtils.isEmpty(str13)) {
            b(stringBuilder, "OS", str13);
        }
        b(stringBuilder, "API", VERSION.SDK_INT);
        return stringBuilder.toString();
    }

    private static void b(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append("&").append(str).append("=").append(str2);
    }

    public static String hW(Context context) {
        if (!TextUtils.isEmpty(AaU)) {
            return AaU;
        }
        String a = a(context, String.valueOf(WebView.getTbsSDKVersion(context)), "0", AaV, AaW, AaX, AaY, AaZ, Aba);
        AaU = a;
        return a;
    }

    private static int hX(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        return defaultDisplay != null ? defaultDisplay.getWidth() : -1;
    }

    private static int hY(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        return defaultDisplay != null ? defaultDisplay.getHeight() : -1;
    }
}

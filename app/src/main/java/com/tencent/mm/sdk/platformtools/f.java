package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.wcdb.FileUtils;
import java.util.Map;

public final class f {
    public static int fdS = 0;
    public static String fdT = (VERSION.SDK_INT);
    public static int fdU = 0;
    public static int fdY = 0;
    public static boolean xeA = false;
    public static boolean xeB = true;
    public static boolean xeC = false;
    public static boolean xeD = false;
    public static int xex = 0;
    public static int xey = 0;
    public static String xez = ("market://details?id=" + ac.getPackageName());

    public static void eH(Context context) {
        try {
            fdS = Integer.parseInt((String) r.UU(bh.convertStreamToString(context.getAssets().open("channel.ini"))).get("CHANNEL"));
        } catch (Throwable e) {
            x.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
            x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
        }
    }

    public static void eI(Context context) {
        try {
            Map UU = r.UU(bh.convertStreamToString(context.getAssets().open("profile.ini")));
            String ou = bh.ou((String) UU.get("PROFILE_DEVICE_TYPE"));
            fdT = ou;
            if (ou.length() <= 0) {
                fdT = VERSION.SDK_INT;
            }
            fdU = parseInt((String) UU.get("UPDATE_MODE"));
            xey = parseInt((String) UU.get("BUILD_REVISION"));
            xeC = parseBoolean((String) UU.get("GPRS_ALERT"));
            fdY = parseInt((String) UU.get("AUTO_ADD_ACOUNT"));
            xeD = parseBoolean((String) UU.get("NOKIA_AOL"));
            x.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + fdT);
            x.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + fdU);
            x.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + xeC);
            x.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + fdY);
            x.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + xeD);
            ou = (String) UU.get("MARKET_URL");
            if (!(ou == null || ou.trim().length() == 0 || Uri.parse(ou) == null)) {
                xez = ou;
            }
            x.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + xez);
        } catch (Throwable e) {
            x.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
            x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
        }
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            x.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
            return 0;
        }
    }

    private static boolean parseBoolean(String str) {
        boolean z = false;
        try {
            z = Boolean.parseBoolean(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[z]);
            x.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
        }
        return z;
    }

    public static String ag(Context context, int i) {
        return b(context, i, xeA);
    }

    public static String b(Context context, int i, boolean z) {
        String str;
        int i2 = (i >> 8) & 255;
        if (i2 == 0) {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255);
        } else {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255) + "." + i2;
        }
        x.d("MicroMsg.SDK.ChannelUtil", "minminor " + i2);
        i2 = 268435455 & i;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), FileUtils.S_IWUSR);
                if (packageInfo != null) {
                    i2 = packageInfo.versionCode;
                    str = packageInfo.versionName;
                }
            } catch (Throwable e) {
                Throwable th = e;
                int i3 = i2;
                x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", th, "", new Object[0]);
                i2 = i3;
            }
        }
        if (z) {
            str = str + "_" + i2;
            x.d("MicroMsg.SDK.ChannelUtil", "full version: " + str);
            return str;
        }
        String[] split = str.split("\\.");
        if (split == null || split.length < 4) {
            return str;
        }
        str = split[0] + "." + split[1];
        return !split[2].trim().equals("0") ? str + "." + split[2] : str;
    }

    public static boolean ceQ() {
        return fdS == 1001;
    }
}

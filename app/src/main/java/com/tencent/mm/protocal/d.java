package com.tencent.mm.protocal;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

public final class d extends e {
    public static String DEVICE_TYPE = ("android-" + VERSION.SDK_INT);
    public static boolean vAA = cdy();
    public static boolean vAB = cdx();
    public static boolean vAC = cdv();
    public static boolean vAD = cdu();
    public static boolean vAE = cdw();
    public static int vAF = 5;
    public static final byte[] vAG = null;
    public static final byte[] vAH = null;
    public static final byte[] vAI = null;
    public static final String vAs = Build.BRAND;
    public static final String vAt = (Build.MODEL + Build.CPU_ABI);
    public static String vAu = ("android-" + VERSION.SDK_INT);
    public static final String vAv = ("android-" + Build.MANUFACTURER);
    public static String vAw = (VERSION.SDK_INT);
    public static final String vAx = (Build.MANUFACTURER + "-" + Build.MODEL);
    public static long vAy = 0;
    public static int vAz;

    public static void CE(int i) {
        vAz = i;
        vAC = cdv();
        vAD = cdu();
        vAA = cdy();
        vAB = cdx();
        vAE = cdw();
    }

    static {
        vAz = Integer.decode("0x26060235").intValue();
        try {
            int i = ac.getContext().getPackageManager().getApplicationInfo(ac.getPackageName(), FileUtils.S_IWUSR).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
            if (i > vAz && i - vAz < 255 && (i & 255) >= 48) {
                vAz = i;
            }
        } catch (Exception e) {
            x.j("MicroMsg.ConstantsProtocal", "", e);
        }
    }

    private static boolean cdu() {
        return (vAz & 255) >= 32 && (vAz & 255) <= 47;
    }

    private static boolean cdv() {
        return (vAz & 255) >= 0 && (vAz & 255) <= 31;
    }

    private static boolean cdw() {
        return (vAz & 255) >= 0 && (vAz & 255) <= 15;
    }

    private static boolean cdx() {
        return (vAz & 255) >= 96 && (vAz & 255) <= JsApiGetBackgroundAudioState.CTRL_INDEX;
    }

    private static boolean cdy() {
        return (vAz & 255) >= 48 && (vAz & 255) <= 95;
    }
}

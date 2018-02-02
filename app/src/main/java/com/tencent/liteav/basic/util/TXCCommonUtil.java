package com.tencent.liteav.basic.util;

public class TXCCommonUtil {
    private static String mStrAppVersion = "";

    private static native int nativeGetSDKID();

    private static native String nativeGetSDKVersion();

    static {
        a.d();
    }

    public static int[] getSDKVersion() {
        String[] split = nativeGetSDKVersion().split("\\.");
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                iArr[i] = Integer.parseInt(split[i]);
            } catch (NumberFormatException e) {
                iArr[i] = 0;
            }
        }
        return iArr;
    }

    public static String getSDKVersionStr() {
        return nativeGetSDKVersion();
    }

    public static int getSDKID() {
        return nativeGetSDKID();
    }

    public static String getFileExtension(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static void sleep(int i) {
        try {
            Thread.sleep((long) i);
        } catch (InterruptedException e) {
        }
    }

    public static void setAppVersion(String str) {
        mStrAppVersion = str;
    }

    public static String getAppVersion() {
        return mStrAppVersion;
    }
}

package com.qq.wx.voice.vad;

public final class a {
    public static boolean DEBUG = false;
    public static boolean bgz = false;
    public long bgw = 0;
    public EVadNative bgx = new EVadNative();
    public MMVoipVadNative bgy = new MMVoipVadNative();

    public static void av(boolean z) {
        bgz = z;
        if (z) {
            System.loadLibrary("MMVoipVadEmbed");
            if (DEBUG) {
                System.out.println("EVad loadLib MMVoipVadEmbed");
                return;
            }
            return;
        }
        System.loadLibrary("EVadEmbed");
        if (DEBUG) {
            System.out.println("EVad loadLib EVadEmbed");
        }
    }
}

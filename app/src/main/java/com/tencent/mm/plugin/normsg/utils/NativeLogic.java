package com.tencent.mm.plugin.normsg.utils;

import android.content.Context;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public final class NativeLogic {
    private static native boolean checkMsgLevel();

    private static native byte[] checkSoftType(String str, int i);

    private static native byte[] checkSoftType2(Context context, String str, int i);

    private static native byte[] checkSoftType3(Context context);

    private static native void checkSoftType4(Context context, Set<String> set, boolean z);

    private static native long checkSoftType5();

    private static native String checkSoftType6(String str);

    private static native boolean checkSoftType7();

    private static native boolean checkSoftType8(Object obj);

    private static native boolean checkSoftType9(Object obj, Class<? extends b> cls);

    private static native boolean secretMsgCheck(Object obj, Class cls);

    private static native int setLog(int i);

    public static boolean bfI() {
        long nanoTime = System.nanoTime();
        boolean checkMsgLevel = checkMsgLevel();
        x.i("MicroMsg.NativeLogic", "call checkMsgLevel, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        d.pPH.c(415, 1, 2, (int) r8, false);
        return checkMsgLevel;
    }

    public static byte[] bO(String str, int i) {
        long nanoTime = System.nanoTime();
        byte[] checkSoftType = checkSoftType(str, i);
        x.i("MicroMsg.NativeLogic", "call checkSoftType, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        d.pPH.c(415, 4, 5, (int) r8, false);
        return checkSoftType;
    }

    public static byte[] h(Context context, String str, int i) {
        long nanoTime = System.nanoTime();
        byte[] checkSoftType2 = checkSoftType2(context, str, i);
        x.i("MicroMsg.NativeLogic", "call checkSoftType2, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        d.pPH.c(415, 7, 8, (int) r8, false);
        return checkSoftType2;
    }

    public static byte[] dk(Context context) {
        long nanoTime = System.nanoTime();
        byte[] checkSoftType3 = checkSoftType3(context);
        x.i("MicroMsg.NativeLogic", "call checkSoftType3, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        d.pPH.c(415, 10, 11, (int) r8, false);
        return checkSoftType3;
    }

    public static void a(Context context, Set<String> set, boolean z) {
        long nanoTime = System.nanoTime();
        checkSoftType4(context, set, z);
        x.i("MicroMsg.NativeLogic", "call checkSoftType4, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        d.pPH.c(415, 13, 14, (int) r6, false);
    }

    public static long bgg() {
        long nanoTime = System.nanoTime();
        long checkSoftType5 = checkSoftType5();
        x.i("MicroMsg.NativeLogic", "call checkSoftType5, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        d.pPH.c(415, 16, 17, (int) r8, false);
        return checkSoftType5;
    }

    public static String GJ(String str) {
        long nanoTime = System.nanoTime();
        String checkSoftType6 = checkSoftType6(str);
        x.i("MicroMsg.NativeLogic", "call checkSoftType6, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        d.pPH.c(415, 19, 20, (int) r8, false);
        return checkSoftType6;
    }

    public static boolean b(Object obj, Class cls) {
        return secretMsgCheck(obj, cls);
    }

    public static boolean bgh() {
        long nanoTime = System.nanoTime();
        boolean checkSoftType7 = checkSoftType7();
        x.i("MicroMsg.NativeLogic", "call checkSoftType7, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        d.pPH.c(415, 22, 23, (int) r8, false);
        return checkSoftType7;
    }

    public static boolean bA(Object obj) {
        long nanoTime = System.nanoTime();
        boolean checkSoftType8 = checkSoftType8(obj);
        x.i("MicroMsg.NativeLogic", "call checkSoftType8, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        d.pPH.c(415, 25, 26, (int) r8, false);
        return checkSoftType8;
    }

    public static void c(Object obj, Class<? extends b> cls) {
        long nanoTime = System.nanoTime();
        checkSoftType9(obj, cls);
        x.i("MicroMsg.NativeLogic", "call checkSoftType9, duration: %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
        d.pPH.c(415, 28, 29, (int) r6, false);
    }

    static {
        k.b("wechatnormsg", NativeLogic.class.getClassLoader());
    }
}

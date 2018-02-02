package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;

public final class d {
    private static long leX = 0;
    private static long leY = 0;
    private static b lfi;
    private static long lfn = 0;
    private static long lfo = 0;
    private static final af lfw = new af();
    private static HashSet<String> lfx;
    private static ArrayList<b> lfy;
    private static int lfz = 0;

    public static void a(b bVar) {
        lfi = bVar;
    }

    public static b ayi() {
        boolean z = true;
        String str = "MicroMsg.CleanLogic";
        String str2 = "getThreadController threadController is null? %b";
        Object[] objArr = new Object[1];
        if (lfi != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        return lfi;
    }

    public static void b(HashSet<String> hashSet) {
        lfx = hashSet;
    }

    public static HashSet<String> ayj() {
        return lfx;
    }

    public static void m(ArrayList<b> arrayList) {
        boolean z = true;
        String str = "MicroMsg.CleanLogic";
        String str2 = "set analyse data: is null? %b";
        Object[] objArr = new Object[1];
        if (arrayList != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        lfy = arrayList;
    }

    public static ArrayList<b> ayk() {
        return lfy;
    }

    public static void bR(long j) {
        lfo = j;
    }

    public static long ayl() {
        return lfo;
    }

    public static void bS(long j) {
        leX = j;
    }

    public static long aym() {
        return leX;
    }

    public static void bT(long j) {
        if (j <= 0) {
            j = 0;
        }
        leY = j;
    }

    public static long ayn() {
        return leY;
    }

    public static void bU(long j) {
        lfn = j;
    }

    public static long ayo() {
        return lfn;
    }

    public static final void ayp() {
        x.i("MicroMsg.CleanLogic", "startCleanDataNow");
        lfw.removeCallbacksAndMessages(null);
        lfo = 0;
        lfn = 0;
        m(null);
        lfz = 0;
    }

    public static final void ayq() {
        x.i("MicroMsg.CleanLogic", "start to post clean runnable!!");
        lfw.removeCallbacksAndMessages(null);
        lfw.postDelayed(new 1(), 300000);
    }

    public static final void ayr() {
        lfz++;
    }

    public static final void ays() {
        lfz--;
    }
}

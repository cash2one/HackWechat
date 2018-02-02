package com.tencent.mm.plugin.backup.f;

import android.os.Looper;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.Queue;

public final class i {
    private static int kps = 300000;
    private a klw;
    ak kpA = new ak(Looper.getMainLooper(), new 1(this), true);
    long kpt = 0;
    long kpu;
    long kpv;
    long kpw;
    long kpx;
    int kpy = 0;
    Queue<Long> kpz = new LinkedList();

    public i(a aVar) {
        this.klw = aVar;
        if (b.ceK()) {
            kps = 60000;
        }
    }

    static String bJ(long j) {
        if ((j >> 30) > 0) {
            return bh.b(j, 100.0d);
        }
        if ((j >> 20) > 0) {
            return bh.a(j, 100.0d);
        }
        if ((j >> 9) <= 0) {
            return j + " B";
        }
        return Math.round(((float) j) / 1024.0f) + " KB";
    }
}

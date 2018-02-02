package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.h$a;
import com.google.android.exoplayer2.i.h.b;
import com.tencent.wcdb.FileUtils;

final class j$a {
    final k alW;
    final SparseArray<b> anF = new SparseArray();
    final SparseArray<h$a> anG = new SparseArray();
    final com.google.android.exoplayer2.i.k anH = new com.google.android.exoplayer2.i.k(this.buffer, 0, 0);
    int anI;
    int anJ;
    long anK;
    long anL;
    a anM = new a((byte) 0);
    a anN = new a((byte) 0);
    boolean anO;
    long anj;
    long anr;
    boolean ans;
    boolean anv;
    final boolean any;
    final boolean anz;
    byte[] buffer = new byte[FileUtils.S_IWUSR];

    public j$a(k kVar, boolean z, boolean z2) {
        this.alW = kVar;
        this.any = z;
        this.anz = z2;
        reset();
    }

    public final void a(b bVar) {
        this.anF.append(bVar.aCh, bVar);
    }

    public final void a(h$a com_google_android_exoplayer2_i_h_a) {
        this.anG.append(com_google_android_exoplayer2_i_h_a.anV, com_google_android_exoplayer2_i_h_a);
    }

    public final void reset() {
        this.anv = false;
        this.anO = false;
        this.anN.clear();
    }
}

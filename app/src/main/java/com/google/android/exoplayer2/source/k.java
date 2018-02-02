package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.b;

public final class k extends w {
    private static final Object asA = new Object();
    private final long afe;
    private final long aff;
    private final boolean afg = true;
    private final boolean afh;
    private final long asB;
    private final long asC;
    private final long asD;
    private final long asE;

    public k(long j, long j2, long j3, long j4, long j5, long j6, boolean z) {
        this.afe = j;
        this.aff = j2;
        this.asB = j3;
        this.asC = j4;
        this.asD = j5;
        this.asE = j6;
        this.afh = z;
    }

    public final int iu() {
        return 1;
    }

    public final b a(int i, b bVar, boolean z, long j) {
        a.as(i, 1);
        long j2 = this.asE;
        if (this.afh) {
            j2 += j;
            if (j2 > this.asC) {
                j2 = -9223372036854775807L;
            }
        }
        long j3 = this.afe;
        long j4 = this.aff;
        boolean z2 = this.afg;
        boolean z3 = this.afh;
        long j5 = this.asC;
        long j6 = this.asD;
        bVar.aeW = null;
        bVar.afe = j3;
        bVar.aff = j4;
        bVar.afg = z2;
        bVar.afh = z3;
        bVar.afk = j2;
        bVar.aes = j5;
        bVar.afi = 0;
        bVar.afj = 0;
        bVar.afl = j6;
        return bVar;
    }

    public final int iv() {
        return 1;
    }

    public final w.a a(int i, w.a aVar, boolean z) {
        Object obj;
        a.as(i, 1);
        if (z) {
            obj = asA;
        } else {
            obj = null;
        }
        long j = this.asB;
        long j2 = -this.asD;
        aVar.aeW = obj;
        aVar.ady = obj;
        aVar.adN = 0;
        aVar.aes = j;
        aVar.aeX = j2;
        aVar.aeY = null;
        aVar.aeZ = null;
        aVar.afa = null;
        aVar.afb = null;
        aVar.afc = null;
        aVar.afd = -9223372036854775807L;
        return aVar;
    }

    public final int U(Object obj) {
        return asA.equals(obj) ? 0 : -1;
    }
}

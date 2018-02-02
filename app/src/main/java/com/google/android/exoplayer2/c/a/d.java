package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.c.a.b.a;
import com.google.android.exoplayer2.i.t;

final class d implements a {
    private final long aes;
    private final long aiS;
    private final long ajj;
    private final long[] ajk;
    private final long ajl;
    private final int ajm;

    d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0, 0);
    }

    d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.aiS = j;
        this.aes = j2;
        this.ajj = j3;
        this.ajk = jArr;
        this.ajl = j4;
        this.ajm = i;
    }

    public final boolean jr() {
        return this.ajk != null;
    }

    public final long y(long j) {
        if (!jr() || j < this.aiS) {
            return 0;
        }
        double d = (256.0d * ((double) (j - this.aiS))) / ((double) this.ajl);
        int a = t.a(this.ajk, (long) d, false) + 1;
        long cm = cm(a);
        long j2 = a == 0 ? 0 : this.ajk[a - 1];
        long j3 = a == 99 ? 256 : this.ajk[a];
        return cm + (j3 == j2 ? 0 : (long) ((((double) (cm(a + 1) - cm)) * (d - ((double) j2))) / ((double) (j3 - j2))));
    }

    private long cm(int i) {
        return (this.aes * ((long) i)) / 100;
    }
}

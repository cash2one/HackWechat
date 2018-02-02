package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.i.t;

final class c implements b$a {
    private final long aes;
    private final long[] aiz;
    private final long[] aji;

    c(long[] jArr, long[] jArr2, long j) {
        this.aiz = jArr;
        this.aji = jArr2;
        this.aes = j;
    }

    public final boolean jr() {
        return true;
    }

    public final long y(long j) {
        return this.aiz[t.a(this.aji, j, true)];
    }
}

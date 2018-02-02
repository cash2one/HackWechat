package com.google.android.exoplayer2.i;

import java.util.Arrays;

public final class e {
    private long[] aCd;
    private int size;

    public e() {
        this((byte) 0);
    }

    private e(byte b) {
        this.aCd = new long[32];
    }

    public final void O(long j) {
        if (this.size == this.aCd.length) {
            this.aCd = Arrays.copyOf(this.aCd, this.size * 2);
        }
        long[] jArr = this.aCd;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = j;
    }

    public final long[] lz() {
        return Arrays.copyOf(this.aCd, this.size);
    }
}

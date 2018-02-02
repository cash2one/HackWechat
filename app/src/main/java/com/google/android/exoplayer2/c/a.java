package com.google.android.exoplayer2.c;

public final class a implements j {
    private final long aes;
    public final int[] aix;
    public final long[] aiy;
    public final long[] aiz;
    public final int length;
    public final long[] offsets;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.aix = iArr;
        this.offsets = jArr;
        this.aiy = jArr2;
        this.aiz = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.aes = jArr2[this.length - 1] + jArr3[this.length - 1];
        } else {
            this.aes = 0;
        }
    }

    public final boolean jr() {
        return true;
    }
}

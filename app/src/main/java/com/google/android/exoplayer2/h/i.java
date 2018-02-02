package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

public final class i {
    public final byte[] aAJ;
    public final long aAK;
    public final long aAL;
    public final String aAM;
    public final int flags;
    public final long position;
    public final Uri uri;

    public i(Uri uri) {
        this(uri, 1);
    }

    public i(Uri uri, long j, long j2) {
        this(uri, j, j, j2, null, 0);
    }

    public i(Uri uri, int i) {
        this(uri, 0, 0, -1, null, 1);
    }

    private i(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, null, i);
    }

    private i(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        a.am(j >= 0);
        a.am(j2 >= 0);
        boolean z = j3 > 0 || j3 == -1;
        a.am(z);
        this.uri = uri;
        this.aAJ = bArr;
        this.aAK = j;
        this.position = j2;
        this.aAL = j3;
        this.aAM = str;
        this.flags = i;
    }

    public final boolean lq() {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        return "DataSpec[" + this.uri + ", " + Arrays.toString(this.aAJ) + ", " + this.aAK + ", " + this.position + ", " + this.aAL + ", " + this.aAM + ", " + this.flags + "]";
    }

    public final i N(long j) {
        long j2 = -1;
        if (this.aAL != -1) {
            j2 = this.aAL - j;
        }
        return (j == 0 && this.aAL == j2) ? this : new i(this.uri, this.aAJ, this.aAK + j, this.position + j, j2, this.aAM, this.flags);
    }
}

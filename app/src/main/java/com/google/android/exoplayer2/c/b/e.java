package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.Format;

public final class e {
    public final Format aeo;
    public final long aes;
    public final int alo;
    public final long amc;
    public final long amd;
    public final int ame;
    public final long[] amf;
    public final long[] amg;
    private final f[] amh;
    public final int id;
    public final int type;

    public e(int i, int i2, long j, long j2, long j3, Format format, int i3, f[] fVarArr, int i4, long[] jArr, long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.amc = j;
        this.amd = j2;
        this.aes = j3;
        this.aeo = format;
        this.ame = i3;
        this.amh = fVarArr;
        this.alo = i4;
        this.amf = jArr;
        this.amg = jArr2;
    }

    public final f cs(int i) {
        return this.amh == null ? null : this.amh[i];
    }
}

package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.r.c;

public abstract class a implements c {
    public final f aiB;
    public final i asH;
    public final Format asI;
    public final int asJ;
    public final Object asK;
    public final long asL;
    public final long asM;
    public final int type;

    public abstract long kp();

    public a(f fVar, i iVar, int i, Format format, int i2, Object obj, long j, long j2) {
        this.aiB = (f) com.google.android.exoplayer2.i.a.Y(fVar);
        this.asH = (i) com.google.android.exoplayer2.i.a.Y(iVar);
        this.type = i;
        this.asI = format;
        this.asJ = i2;
        this.asK = obj;
        this.asL = j;
        this.asM = j2;
    }
}
